package app.subscription.service;

import app.subscription.model.Subscription;
import app.subscription.model.SubscriptionPeriod;
import app.subscription.model.SubscriptionStatus;
import app.subscription.model.SubscriptionType;
import app.subscription.repository.SubscriptionRepository;
import app.user.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }


    public void createDefaultSubscription(User user) {

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

        subscriptionRepository.save(subscription);
    }
}
