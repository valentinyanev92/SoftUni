package app.web;

import app.user.model.User;
import app.user.property.UserProperties;
import app.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final UserService userService;
    private final UserProperties userProperties;

    public SubscriptionController(UserService userService, UserProperties userProperties) {
        this.userService = userService;
        this.userProperties = userProperties;
    }

    @GetMapping
    public String getUpgradePage() {

        return "upgrade";
    }

    @GetMapping("/history")
    public ModelAndView getHistoryPage() {

        User user = userService.getByUsername(userProperties.getDefaultUser().getUsername());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("subscription-history");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
