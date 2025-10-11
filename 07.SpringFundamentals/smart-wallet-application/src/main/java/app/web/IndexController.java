package app.web;

import app.transaction.model.Transaction;
import app.transaction.service.TransactionService;
import app.user.model.User;
import app.user.property.UserProperties;
import app.user.service.UserService;
import app.web.dto.EditProfileRequest;
import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/")
public class IndexController {

    private final UserService userService;
    private final UserProperties userProperties;
    private final TransactionService transactionService;

    @Autowired
    public IndexController(UserService userService, UserProperties userProperties, TransactionService transactionService) {
        this.userService = userService;
        this.userProperties = userProperties;
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public ModelAndView getIndexPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(RedirectAttributes redirectAttributes){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("loginRequest", new LoginRequest());

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginRequest loginRequest, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ModelAndView("login");
        }

        userService.login(loginRequest);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("registerRequest",  new RegisterRequest());

        return modelAndView;
    }

    @PutMapping("/register")
    public ModelAndView registerUser(@Valid RegisterRequest registerRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            return new ModelAndView("register");
        }

        userService.register(registerRequest);

        redirectAttributes.addFlashAttribute("successfulRegistration", "You have registered successfully!");
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/home")
    public ModelAndView getHomePage(){

        User user = userService.getByUsername(userProperties.getDefaultUser().getUsername());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @GetMapping("/reports")
    public ModelAndView getReportsPage(){

        User user = userService.getByUsername(userProperties.getDefaultUser().getUsername());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("reports");

        return modelAndView;
    }

    @GetMapping("/transactions")
    public ModelAndView getTransactionsPage(){

        User user = userService.getByUsername(userProperties.getDefaultUser().getUsername());
        List<Transaction> transactions = transactionService.getByUserId(user.getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("transactions", transactions);
        modelAndView.setViewName("transactions");

        return modelAndView;
    }
}
