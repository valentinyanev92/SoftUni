package main.web;

import jakarta.servlet.http.HttpSession;
import main.model.Mob;
import main.model.Player;
import main.property.ClassProperties.ClassDetail.Booster;
import main.service.MobService;
import main.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class LobbyController {

    private final PlayerService playerService;
    private final MobService mobService;

    public LobbyController(PlayerService playerService, MobService mobService) {
        this.playerService = playerService;
        this.mobService = mobService;
    }

    @GetMapping("/lobby")
    public ModelAndView getLobby(HttpSession session) {

        Player player = playerService.getById((UUID) session.getAttribute("user_id"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("player", player);

        List<Booster> boosters = playerService.getBoosters(player.getPlayerClass());
        modelAndView.addObject("boosters", boosters);

        List<Mob> last3Mobs = mobService.getLast3Mobs();
        modelAndView.addObject("lastMobs", last3Mobs);

        List<Player> playersForParty = playerService.findAll().stream().filter(s -> !s.equals(player)).filter(s -> s.getParty() == null).toList();
        modelAndView.addObject("playersForParty", playersForParty);

        List<Player> partyMembers = playerService.findAllByParty(player.getParty());
        modelAndView.addObject("partyMembers", partyMembers);

        modelAndView.setViewName("lobby");
        return modelAndView;
    }

}
