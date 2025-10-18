package main.web;

import jakarta.servlet.http.HttpSession;
import main.model.Player;
import main.service.PartyService;
import main.service.PlayerService;
import main.web.dto.ClassRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class ClassesController {

    private final PlayerService playerService;

    public ClassesController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/class")
    public ModelAndView getClasses() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classes");
        modelAndView.addObject("classRequest", new ClassRequest());

        return modelAndView;
    }

    @PostMapping("/players/me/class")
    public ModelAndView chooseClass(ClassRequest classRequest, HttpSession session) {

        Player player = playerService.getById((UUID) session.getAttribute("user_id"));
        playerService.choiceClass(player, classRequest);

        return  new ModelAndView("redirect:/lobby");
    }
}
