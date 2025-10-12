package app.job;

import app.email.EmailService;
import app.user.model.User;
import app.user.model.UserRole;
import app.user.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminReminderScheduler {

    private final UserService userService;
    private final EmailService emailService;

    public AdminReminderScheduler(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

//    @Scheduled(fixedRate = 60000)
    public void sendReminderToAdmins() {

        List<User> admins = userService.getAll()
                .stream()
                .filter(user -> user.getRole() == UserRole.ADMIN)
                .toList();

        admins.forEach(admin -> emailService.sendReminderEmail(admin));

    }
}
