package springdataintro.services;

import org.springframework.stereotype.Service;
import springdataintro.entities.Account;
import springdataintro.entities.User;
import springdataintro.repositories.AccountRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public void withdrawMoney(BigDecimal amount, long id) {
//        Account account = accountRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Account not found"));

        Optional<Account> byId = accountRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Account with id " + id + " not found");
        }

        Account account = byId.get();
        if (account.getBalance().compareTo(amount) < 0) throw new RuntimeException("Insufficient balance");

        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);
    }

    public void transferMoney(BigDecimal amount, User user, long id) {
        Optional<Account> byId = accountRepository.findById(id);
        if (byId.isEmpty()) throw new RuntimeException("Account with id " + id + " not found");

        Account account = byId.get();
        if (account.getBalance().compareTo(amount) < 0) throw new RuntimeException("Insufficient balance");

        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
    }
}