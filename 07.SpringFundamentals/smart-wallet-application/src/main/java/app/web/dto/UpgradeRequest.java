package app.web.dto;

import app.subscription.model.SubscriptionPeriod;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpgradeRequest {

    @NotNull
    private SubscriptionPeriod subscriptionPeriod;

    @NotNull
    private UUID walletId;
}
