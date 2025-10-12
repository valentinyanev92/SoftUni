package app.email;

import app.event.SuccessfullyChargeEvent;
import app.user.model.User;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @EventListener
    @Async
    public void sendEmail(SuccessfullyChargeEvent event) {

        System.out.printf("Sending email for new charge happens for user with email [%s]%n", event.getEmail());
    }

    public void sendReminderEmail(User admin) {

        System.out.printf("Email sent to [%s] with username [%s]%n", admin.getEmail(), admin.getUsername());
    }
}
