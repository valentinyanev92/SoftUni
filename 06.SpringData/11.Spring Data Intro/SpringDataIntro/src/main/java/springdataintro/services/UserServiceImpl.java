package springdataintro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintro.entities.Account;
import springdataintro.entities.User;
import springdataintro.repositories.AccountRepository;
import springdataintro.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            System.out.println("User with that username is already registered");
        } else {
            Account account = new Account();
            user.addAccount(account);

            userRepository.save(user);

        }
    }

    @Override
    public Optional<User> find(String username) {
        return userRepository.findByUsername(username);
    }
}
