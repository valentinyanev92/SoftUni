package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Item;
import main.model.Player;
import main.model.Quest;
import main.service.ItemService;
import main.service.PlayerService;
import main.service.QuestService;
import main.web.dto.QuestUploadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class QuestController {

    private final PlayerService playerService;
    private final ItemService itemService;
    private final QuestService questService;

    @Autowired
    public QuestController(PlayerService playerService, ItemService itemService, QuestService questService) {
        this.playerService = playerService;
        this.itemService = itemService;
        this.questService = questService;
    }

    @GetMapping("/quests")
    public ModelAndView getQuestsPage(HttpSession session) {

        Player player = playerService.getById((UUID) session.getAttribute("playerId"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("quests");
        modelAndView.addObject("player", player);
        modelAndView.addObject("questUploadRequest", new QuestUploadRequest());

        List<Item> itemList = itemService.getAll();
        modelAndView.addObject("itemList", itemList);

        List<Quest> questList = questService.getAll();
        modelAndView.addObject("questList", questList);
        return modelAndView;
    }

    @PostMapping("/quests")
    public ModelAndView uploadQuest(@Valid QuestUploadRequest questUploadRequest, BindingResult bindingResult, HttpSession session) {


        if (bindingResult.hasErrors()) {
            return new ModelAndView("quests");
        }

        Player player = playerService.getById((UUID) session.getAttribute("playerId"));
        Quest quest = questService.uploadQuest(questUploadRequest, player);
        return new ModelAndView("redirect:/quests");
    }
}
