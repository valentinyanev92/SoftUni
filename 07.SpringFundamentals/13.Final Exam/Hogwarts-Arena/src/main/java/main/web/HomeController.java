package main.web;

import jakarta.persistence.Column;
import jakarta.servlet.http.HttpSession;
import main.model.Spell;
import main.model.Wizard;
import main.property.SpellsProperties;
import main.service.SpellService;
import main.service.WizardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final WizardService wizardService;
    private final SpellService spellService;

    public HomeController(WizardService wizardService, SpellService spellService) {
        this.wizardService = wizardService;
        this.spellService = spellService;
    }

    @GetMapping
    public ModelAndView getHome(HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        Wizard wizard = wizardService.getById((UUID) session.getAttribute("user_id"));
        modelAndView.addObject("wizard", wizard);

        List<Spell> learnedSpells = wizard.getSpells().stream().sorted(Comparator.comparingInt(Spell::getPower).reversed()).toList();
        modelAndView.addObject("learnedSpells", learnedSpells);

//        List<SpellsProperties.Spell> availableSpells = spellService.getAllUnlearnedAndAvailableSpells(wizard);
//        List<SpellsProperties.Spell> unavailableSpells = spellService.getAllUnlearnedAndUnavailableSpells(wizard);
//        modelAndView.addObject("availableSpells", availableSpells);
//        modelAndView.addObject("unavailableSpells", unavailableSpells);

        List<SpellsProperties.Spell> unlearnedSpells = spellService.getAllUnlearnedSpells(wizard);
        modelAndView.addObject("unlearnedSpells", unlearnedSpells);

        return modelAndView;
    }

}
