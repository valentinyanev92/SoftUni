package app.event;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuccessfullyChargeEvent {

    private UUID userId;

    private UUID walletId;

    private String email;

    private BigDecimal amount;

    private LocalDateTime createdOn;
}
