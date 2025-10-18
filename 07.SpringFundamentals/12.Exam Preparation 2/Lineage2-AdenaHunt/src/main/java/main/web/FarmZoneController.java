package main.web;

import jakarta.servlet.http.HttpSession;
import main.model.Mob;
import main.model.Player;
import main.service.MobService;
import main.service.PlayerService;
import main.web.dto.FightResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/mobs")
public class FarmZoneController {

    private final PlayerService playerService;
    private final MobService mobService;

    public FarmZoneController(PlayerService playerService, MobService mobService) {
        this.playerService = playerService;
        this.mobService = mobService;
    }

    @GetMapping
    public ModelAndView showZone(HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();
        Player player = playerService.getById((UUID) session.getAttribute("user_id"));
        modelAndView.addObject("player", player);

        List<Mob> mobs = mobService.getAllMobs();
        modelAndView.addObject("mobs", mobs);




        modelAndView.setViewName("farm-zone");
        return modelAndView;
    }


    @PatchMapping("/{id}")
    public String attackMob(@PathVariable("id") UUID mobId, HttpSession session, RedirectAttributes redirectAttributes) {

        UUID attackerId = (UUID) session.getAttribute("user_id");

        FightResult fightResult = mobService.attack(attackerId, mobId);
        redirectAttributes.addFlashAttribute("fightResult", fightResult);

        return "redirect:/mobs";
    }
}
