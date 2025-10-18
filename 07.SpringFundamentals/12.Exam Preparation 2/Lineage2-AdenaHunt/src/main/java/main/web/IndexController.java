package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Player;
import main.service.PlayerService;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

    private final PlayerService playerService;

    @Autowired
    public IndexController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String getIndexPage(){

        return "index";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("registerRequest",new RegisterRequest());

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid RegisterRequest registerRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            return new ModelAndView("register");
        }

        playerService.registerUser(registerRequest);

        redirectAttributes.addFlashAttribute("successfulRegistration","Register successful");
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("loginRequest",new LoginRequest());

        return  modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@Valid LoginRequest loginRequest, BindingResult bindingResult, HttpSession session){

        if (bindingResult.hasErrors()){
            return new ModelAndView("login");
        }

        Player player = playerService.login(loginRequest);
        session.setAttribute("user_id",player.getId());

        return  new ModelAndView("redirect:/lobby");
    }

    @GetMapping("logout")
    public ModelAndView getLogoutPage(HttpSession session){

        session.invalidate();

        return new ModelAndView("redirect:/");
    }
}
