package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Item;
import main.model.Player;
import main.model.Quest;
import main.service.PlayerService;
import main.service.QuestService;
import main.web.dto.QuestRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class AdventurerController {

    private final PlayerService playerService;
    private final QuestService questService;

    @Autowired
    public AdventurerController(PlayerService playerService, QuestService questService) {
        this.playerService = playerService;
        this.questService = questService;
    }

    @GetMapping("/adventurer-home")
    public ModelAndView getAdventurerHomePage(HttpSession session) {

        Player player = playerService.getById((UUID) session.getAttribute("playerId"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adventurer-home");
        modelAndView.addObject("player", player);

        double xpPercentToNextLevel = 100 - player.getProgress();
        modelAndView.addObject("xpPercentToNextLevel", xpPercentToNextLevel);

        List<Quest> availableQuests = questService.getAllAvailableQuestsForCurrentPlayer(player);
        List<Quest> completedQuests = questService.getAllCompletedQuestsByUser(player);
        List<Item> obtainedItems = new ArrayList<>();
        completedQuests.forEach(quest -> {
            obtainedItems.add(quest.getRewardItem());
        });
        modelAndView.addObject("availableQuests", availableQuests);
        modelAndView.addObject("obtainedItems", obtainedItems);
        modelAndView.addObject("questRequest", new QuestRequest());

        return modelAndView;
    }

    //todo POST for adventurer-home for questRequest
    @PostMapping("/adventurer-home")
    public ModelAndView getQuest(@Valid QuestRequest questRequest, BindingResult bindingResult, HttpSession session, ModelAndView modelAndView) {

        Player player = playerService.getById((UUID) session.getAttribute("playerId"));
        playerService.getQuest(questRequest, player);

        return new ModelAndView("redirect:/adventurer-home");
    }
}
