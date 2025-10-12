package app.wallet.service;

import app.event.SuccessfullyChargeEvent;
import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.transaction.model.TransactionType;
import app.transaction.service.TransactionService;
import app.user.model.User;
import app.wallet.model.Wallet;
import app.wallet.model.WalletStatus;
import app.wallet.repository.WalletRepository;
import app.web.dto.TransferRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Slf4j
@Service
public class WalletService {

    private static final String SMART_WALLET_IDENTIFIER = "Smart wallet platform";
    private static final String INACTIVE_WALLET_FAILURE_REASON = "Inactive wallet";
    private static final String INSUFFICIENT_FUNDS_WALLET_FAILURE_REASON = "Not enough funds";
    private static final String WALLET_NOT_OWN_FAILURE_REASON = "You don't own this wallet";

    private static final String TOP_UP_DESCRIPTION_FORMAT = "Top-up %.2f";
    private static final String TRANSFER_DESCRIPTION_FORMAT = "Transfer %s <> %s (%.2f)";

    private static final BigDecimal INITIAL_WALLET_BALANCE = new BigDecimal("20.00");
    private static final Currency DEFAULT_WALLET_CURRENCY = Currency.getInstance("EUR");

    private final WalletRepository walletRepository;
    private final TransactionService transactionService;

    private final ApplicationEventPublisher eventPublisher;

    public WalletService(WalletRepository walletRepository, TransactionService transactionService, ApplicationEventPublisher eventPublisher) {
        this.walletRepository = walletRepository;
        this.transactionService = transactionService;
        this.eventPublisher = eventPublisher;
    }


    public Wallet createDefaultWallet(User user) {

        Wallet wallet = Wallet.builder()
                .owner(user)
                .status(WalletStatus.ACTIVE)
                .balance(INITIAL_WALLET_BALANCE)
                .currency(DEFAULT_WALLET_CURRENCY)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        return walletRepository.save(wallet);
    }

    @Transactional
    public Transaction withdrawal(User user, UUID walletId, BigDecimal amount, String description) {

        Wallet wallet = getById(walletId);

        Transaction transaction = Transaction.builder()
                .owner(user)
                .sender(wallet.getId().toString())
                .receiver(SMART_WALLET_IDENTIFIER)
                .amount(amount)
                .currency(wallet.getCurrency())
                .type(TransactionType.WITHDRAWAL)
                .description(description)
                .createdOn(LocalDateTime.now())
                .build();

        if (!isActiveWallet(wallet)) {
            transaction.setFailureReason(INACTIVE_WALLET_FAILURE_REASON);
            transaction.setStatus(TransactionStatus.FAILED);
        } else if (!hasSufficientFunds(wallet, amount)) {
            transaction.setFailureReason(INSUFFICIENT_FUNDS_WALLET_FAILURE_REASON);
            transaction.setStatus(TransactionStatus.FAILED);
        } else if (!isWalletOwnedByUser(wallet, user)) {
            transaction.setFailureReason(WALLET_NOT_OWN_FAILURE_REASON);
            transaction.setStatus(TransactionStatus.FAILED);
        } else {
            transaction.setStatus(TransactionStatus.SUCCEEDED);
            wallet.setBalance(wallet.getBalance().subtract(amount));
            wallet.setUpdatedOn(LocalDateTime.now());
            walletRepository.save(wallet);

            SuccessfullyChargeEvent event = SuccessfullyChargeEvent.builder()
                    .userId(user.getId())
                    .walletId(wallet.getId())
                    .amount(amount)
                    .email(user.getEmail())
                    .createdOn(LocalDateTime.now())
                    .build();
            eventPublisher.publishEvent(event);
        }

        transaction.setBalanceLeft(wallet.getBalance());

        return transactionService.upsert(transaction);
    }

    public boolean isWalletOwnedByUser(Wallet wallet, User user) {

        return wallet.getOwner().getId().equals(user.getId());
    }

    public boolean isActiveWallet(Wallet wallet) {

        return wallet.getStatus() == WalletStatus.ACTIVE;
    }

    public boolean hasSufficientFunds(Wallet wallet, BigDecimal amount) {

        return wallet.getBalance().compareTo(amount) >= 0;
    }

    @Transactional
    public Transaction deposit(UUID walletId, BigDecimal amount, String description) {

        Wallet wallet = getById(walletId);

        if (wallet.getStatus() == WalletStatus.INACTIVE) {

            return transactionService.createNewTransaction(wallet.getOwner(),
                    SMART_WALLET_IDENTIFIER,
                    wallet.getId().toString(),
                    amount,
                    wallet.getBalance(),
                    wallet.getCurrency(),
                    TransactionType.DEPOSIT,
                    TransactionStatus.FAILED,
                    description,
                    INACTIVE_WALLET_FAILURE_REASON
            );
        }

        wallet.setBalance(wallet.getBalance().add(amount));
        wallet.setUpdatedOn(LocalDateTime.now());

        walletRepository.save(wallet);

        return transactionService.createNewTransaction(wallet.getOwner(),
                SMART_WALLET_IDENTIFIER,
                wallet.getId().toString(),
                amount,
                wallet.getBalance(),
                wallet.getCurrency(),
                TransactionType.DEPOSIT,
                TransactionStatus.SUCCEEDED,
                description,
                null
        );
    }

    private Wallet getById(UUID walletId) {

        return walletRepository.findById(walletId).orElseThrow(() -> new RuntimeException("Wallet by ID [%s] not found".formatted(walletId)));
    }

    @Transactional
    public Transaction transfer(@Valid TransferRequest transferRequest) {

        Wallet senderWallet = getById(transferRequest.getWalletId());
        Wallet recivierWallet = getFistByUsername(transferRequest.getRecipientUsername());

        String description = TRANSFER_DESCRIPTION_FORMAT.formatted(senderWallet.getOwner().getUsername(), recivierWallet.getOwner().getUsername(), transferRequest.getAmount());
        Transaction withdrawalTransaction = withdrawal(senderWallet.getOwner(), senderWallet.getId(), transferRequest.getAmount(), description);
        if (withdrawalTransaction.getStatus() == TransactionStatus.SUCCEEDED) {
            deposit(recivierWallet.getId(), transferRequest.getAmount(), description);
        }

        return withdrawalTransaction;
    }

    private Wallet getFistByUsername(@NotBlank String recipientUsername) {
        return walletRepository.findByOwnerUsername(recipientUsername)
                .stream().filter(wallet -> isActiveWallet(wallet))
                .findFirst().orElseThrow(() -> new RuntimeException("[%s] doesn't have any active wallets".formatted(recipientUsername)));
    }
}
