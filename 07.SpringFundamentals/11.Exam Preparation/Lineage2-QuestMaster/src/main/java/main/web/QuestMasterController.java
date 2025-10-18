package main.web;

import jakarta.servlet.http.HttpSession;
import main.model.Player;
import main.model.PlayerRole;
import main.service.ItemService;
import main.service.PlayerService;
import main.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class QuestMasterController {

    private final PlayerService playerService;
    private final ItemService itemService;
    private final QuestService questService;

    @Autowired
    public QuestMasterController(PlayerService playerService, ItemService itemService, QuestService questService) {
        this.playerService = playerService;
        this.itemService = itemService;
        this.questService = questService;
    }

    @GetMapping("/quest-master-home")
    public ModelAndView getQuestMasterHomePage(HttpSession session) {

        Player player = playerService.getById((UUID) session.getAttribute("playerId"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("quest-master-home");
        modelAndView.addObject("player", player);

        List<Player> adventurers = playerService.getAllPlayers().stream().filter(adventurer -> adventurer.getRole().equals(PlayerRole.ADVENTURER)).toList();
        int adventurerCount = adventurers.size();
        int itemsCount = itemService.getItemsCount();
        int questCount = questService.getQuestsCount();
        modelAndView.addObject("adventurerCount", adventurerCount);
        modelAndView.addObject("adventurersList", adventurers);
        modelAndView.addObject("itemsCount", itemsCount);
        modelAndView.addObject("questsCount", questCount);

        return modelAndView;
    }
}
