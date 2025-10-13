package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Item;
import main.model.Player;
import main.service.ItemService;
import main.service.PlayerService;
import main.web.dto.ItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class ItemController {

    private final PlayerService playerService;
    private final ItemService itemService;

    @Autowired
    public ItemController(PlayerService playerService, ItemService itemService) {
        this.playerService = playerService;
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public ModelAndView getItemsPage(HttpSession session) {

        Player player = playerService.getById((UUID) session.getAttribute("playerId"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("items");
        modelAndView.addObject("player", player);
        modelAndView.addObject("itemRequest", new ItemRequest());

        List<Item> itemList = itemService.getAll();
        modelAndView.addObject("itemList", itemList);

        return modelAndView;
    }

    @PostMapping("/items")
    public ModelAndView addItem(@Valid ItemRequest itemRequest, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("items");
        }

        Player player = playerService.getById((UUID) session.getAttribute("playerId"));
        itemService.addItem(itemRequest, player);

        return new ModelAndView("redirect:/items");
    }
}
