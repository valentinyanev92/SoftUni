package app.user.service;

import app.user.model.User;
import app.user.property.UserProperties;
import app.web.dto.RegisterRequest;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserInit implements ApplicationRunner {

    private final UserService userService;
    private final UserProperties userProperties;

    public UserInit(UserService userService, UserProperties userProperties) {
        this.userService = userService;
        this.userProperties = userProperties;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<User> users = userService.getAll();
        boolean defaultUserExist = users.stream()
                .anyMatch(user -> user.getUsername().equals(userProperties.getDefaultUser().getUsername()));

        if (!defaultUserExist) {
        RegisterRequest registerRequest = RegisterRequest.builder()
                .username(userProperties.getDefaultUser().getUsername())
                .password(userProperties.getDefaultUser().getPassword())
                .country(userProperties.getDefaultUser().getCountry())
                .build();

        userService.register(registerRequest);

        }
    }
}
