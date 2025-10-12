package app.gift;

import app.event.SuccessfullyChargeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class GiftService {

    @EventListener
    @Async
    public void sendGift(SuccessfullyChargeEvent event) {

        System.out.println("Sending 1 EUR for charge compensation for user with email [" + event.getEmail() + "]");
    }
}
