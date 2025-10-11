package app.subscription.service;

import app.subscription.model.Subscription;
import app.subscription.model.SubscriptionPeriod;
import app.subscription.model.SubscriptionStatus;
import app.subscription.model.SubscriptionType;
import app.subscription.repository.SubscriptionRepository;
import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.user.model.User;
import app.wallet.service.WalletService;
import app.web.dto.UpgradeRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final WalletService walletService;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, WalletService walletService) {
        this.subscriptionRepository = subscriptionRepository;
        this.walletService = walletService;
    }


    public Subscription createDefaultSubscription(User user) {

        Subscription subscription = Subscription.builder()
                .owner(user)
                .status(SubscriptionStatus.ACTIVE)
                .period(SubscriptionPeriod.MONTHLY)
                .type(SubscriptionType.DEFAULT)
                .price(BigDecimal.ZERO)
                .renewalAllowed(true)
                .createdOn(LocalDateTime.now())
                .expiryOn(LocalDateTime.now().plusMonths(1))
                .build();

        return subscriptionRepository.save(subscription);
    }


    public Transaction upgrade(User user, UpgradeRequest upgradeRequest, SubscriptionType subscriptionType) {

        Optional<Subscription> currentSubscription = subscriptionRepository.findByStatusAndOwnerId(SubscriptionStatus.ACTIVE, user.getId());
        if (currentSubscription.isEmpty()) {
            throw new RuntimeException("No active subscription was found for user with id [%s]".formatted(user.getId()));
        }

        Subscription currentlyActiveSubscription = currentSubscription.get();
        BigDecimal subscriptionPrice = getUpgradePrice(subscriptionType, upgradeRequest.getSubscriptionPeriod());
        String description = "Upgrade request for %s %s".formatted(upgradeRequest.getSubscriptionPeriod(), subscriptionType);

        Transaction chargeResultTransaction = walletService.withdrawal(user, upgradeRequest.getWalletId(), subscriptionPrice, description);
        if (chargeResultTransaction.getStatus() == TransactionStatus.FAILED){
            return chargeResultTransaction;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiry;

        if (upgradeRequest.getSubscriptionPeriod() == SubscriptionPeriod.MONTHLY) {
            expiry = now.plusMonths(1).truncatedTo(ChronoUnit.DAYS);
        }else {
            expiry = now.plusYears(1).truncatedTo(ChronoUnit.DAYS);
        }

        Subscription newActiveSubscription = Subscription.builder()
                .owner(user)
                .period(upgradeRequest.getSubscriptionPeriod())
                .status(SubscriptionStatus.ACTIVE)
                .period(upgradeRequest.getSubscriptionPeriod())
                .type(subscriptionType)
                .price(subscriptionPrice)
                .renewalAllowed(upgradeRequest.getSubscriptionPeriod() == SubscriptionPeriod.MONTHLY)
                .createdOn(now)
                .expiryOn(expiry)
                .build();

        currentlyActiveSubscription.setStatus(SubscriptionStatus.COMPLETED);
        currentlyActiveSubscription.setExpiryOn(LocalDateTime.now());

        subscriptionRepository.save(currentlyActiveSubscription);
        subscriptionRepository.save(newActiveSubscription);

        return chargeResultTransaction;
    }

    private BigDecimal getUpgradePrice(SubscriptionType subscriptionType, @NotNull SubscriptionPeriod subscriptionPeriod) {
        if (subscriptionType == SubscriptionType.DEFAULT) {
            return BigDecimal.ZERO;
        } else if (subscriptionType == SubscriptionType.PREMIUM && subscriptionPeriod == SubscriptionPeriod.MONTHLY) {
            return BigDecimal.valueOf(19.99);
        } else if (subscriptionType == SubscriptionType.PREMIUM && subscriptionPeriod == SubscriptionPeriod.YEARLY) {
            return BigDecimal.valueOf(199.99);
        } else if (subscriptionType == SubscriptionType.ULTIMATE && subscriptionPeriod == SubscriptionPeriod.MONTHLY) {
            return BigDecimal.valueOf(49.99);
        } else if (subscriptionType == SubscriptionType.ULTIMATE && subscriptionPeriod == SubscriptionPeriod.YEARLY) {
            return BigDecimal.valueOf(499.99);
        }

        throw new RuntimeException("Price not found for subscription type [%s] and period [%s]".formatted(subscriptionType, subscriptionPeriod));
    }
}
