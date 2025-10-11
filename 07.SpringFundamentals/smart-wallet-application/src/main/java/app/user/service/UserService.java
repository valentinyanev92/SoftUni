package app.user.service;

import app.subscription.model.Subscription;
import app.subscription.service.SubscriptionService;
import app.user.model.User;
import app.user.model.UserRole;
import app.user.property.UserProperties;
import app.user.repository.UserRepository;
import app.wallet.model.Wallet;
import app.wallet.service.WalletService;
import app.web.dto.EditProfileRequest;
import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final WalletService walletService;
    private final SubscriptionService subscriptionService;
    private final UserProperties userProperties;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, WalletService walletService, SubscriptionService subscriptionService, UserProperties userProperties) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.walletService = walletService;
        this.subscriptionService = subscriptionService;
        this.userProperties = userProperties;
    }

    public User login(LoginRequest loginRequest) {

        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());
        if (optionalUser.isEmpty()
                || !passwordEncoder.matches(loginRequest.getPassword(), optionalUser.get().getPassword())) {
            throw new RuntimeException("Incorrect username or password");
        }

        return optionalUser.get();
    }

    @Transactional
    public User register(RegisterRequest registerRequest) {

        Optional<User> optionalUser = userRepository.findByUsername(registerRequest.getUsername());
        if (optionalUser.isPresent()) {
            throw new RuntimeException("User with [%s] already exists.".formatted(registerRequest.getUsername()));
        }

        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(UserRole.USER)
                .country(registerRequest.getCountry())
                .active(true)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        user = userRepository.save(user);
        Wallet defaultWallet = walletService.createDefaultWallet(user);
        Subscription defaultSubscription = subscriptionService.createDefaultSubscription(user);

        user.setWallets(List.of(defaultWallet));
        user.setSubscriptions(List.of(defaultSubscription));

        log.info("User with username \"[%s]\" has been registered successfully".formatted(user.getUsername()));

        return user;
    }

    public List<User> getAll() {

        return userRepository.findAll();
    }


    public User getByUsername(String username) {

        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User with [%s] doest not exists.".formatted(username)));
    }

    public User getById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with [%s] do not exists.".formatted(id)));
    }

    public void editProfile(UUID id, EditProfileRequest editProfileRequest) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with [%s] do not exists.".formatted(id)));
        user.setFirstName(editProfileRequest.getFirstName());
        user.setLastName(editProfileRequest.getLastName());
        user.setEmail(editProfileRequest.getEmail());
        user.setProfilePicture(editProfileRequest.getImageUrl());
        userRepository.save(user);
    }

    public User getDefaultUser() {

        return getByUsername(userProperties.getDefaultUser().getUsername());
    }
}
