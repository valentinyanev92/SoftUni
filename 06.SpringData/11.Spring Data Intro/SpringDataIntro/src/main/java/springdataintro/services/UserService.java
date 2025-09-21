package springdataintro.services;

import springdataintro.entities.User;

import java.util.Optional;

public interface UserService {
    void registerUser(User user);

    Optional<User> find(String username);

}
