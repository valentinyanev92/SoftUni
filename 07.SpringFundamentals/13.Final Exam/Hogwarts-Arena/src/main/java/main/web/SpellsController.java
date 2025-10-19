package main.web;

import jakarta.servlet.http.HttpSession;
import main.model.Wizard;
import main.service.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/spells")
public class SpellsController {

    private final WizardService wizardService;

    @Autowired
    public SpellsController(WizardService wizardService) {
        this.wizardService = wizardService;
    }

    @PostMapping()
    public String learnSpell(@RequestParam("spell-code") String spellCode, HttpSession session) {

        Wizard wizard = wizardService.getById((UUID) session.getAttribute("user_id"));
        wizardService.learnSpell(wizard, spellCode);

        return "redirect:/home";
    }
}
