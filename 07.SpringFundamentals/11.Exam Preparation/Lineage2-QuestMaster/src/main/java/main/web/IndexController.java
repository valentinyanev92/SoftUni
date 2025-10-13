package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Item;
import main.model.Player;
import main.model.PlayerRole;
import main.model.Quest;
import main.service.ItemService;
import main.service.PlayerService;
import main.service.QuestService;
import main.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class IndexController {

    private final PlayerService playerService;

    @Autowired
    public IndexController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String getIndexPage() {

        return "index";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("registerRequest", new RegisterRequest());

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerPlayer(@Valid RegisterRequest registerRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }

        playerService.register(registerRequest);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("loginRequest", new LoginRequest());

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginPlayer(@Valid LoginRequest loginRequest, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("login");
        }

        Player player = playerService.login(loginRequest);
        session.setAttribute("playerId", player.getId());

        if (player.getRole() == null) {
            return new ModelAndView("redirect:/role-select");
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/role-select")
    public ModelAndView getRoleSelectionPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-select");
        modelAndView.addObject("roleRequest", new RoleRequest());

        return modelAndView;
    }

    @PostMapping("/role-select")
    public ModelAndView setRoleSelection(@Valid RoleRequest roleRequest, HttpSession session) {

        UUID playerId = (UUID) session.getAttribute("playerId");
        Player player = playerService.getById(playerId);

        playerService.setRole(player, roleRequest);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home")
    public ModelAndView getProperRedirect(HttpSession session) {

        Player player = playerService.getById((UUID) session.getAttribute("playerId"));

        if (player.getRole() == PlayerRole.QUEST_MASTER) {
            return new ModelAndView("redirect:/quest-master-home");
        }else {
            return new ModelAndView("redirect:/adventurer-home");
        }
    }


    @GetMapping("/logout")
    public ModelAndView getLogoutPage(HttpSession session) {

        session.invalidate();
        return new ModelAndView("redirect:/");
    }
}
