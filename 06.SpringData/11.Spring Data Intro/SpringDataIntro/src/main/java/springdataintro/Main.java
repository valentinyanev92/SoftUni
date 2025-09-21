package springdataintro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdataintro.entities.User;
import springdataintro.services.AccountServiceImpl;
import springdataintro.services.UserService;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class Main implements CommandLineRunner {

    private final UserService userService;
    private final AccountServiceImpl accountService;

    @Autowired
    public Main(UserService userService, AccountServiceImpl accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started from spring!!!");

        User user = new User("mladen", 24);
        userService.registerUser(user);

        accountService.withdrawMoney(BigDecimal.valueOf(10), 1);

        Optional<User> find = userService.find("mladen");

        accountService.transferMoney(BigDecimal.valueOf(1), find.get(), 1L);
    }
}