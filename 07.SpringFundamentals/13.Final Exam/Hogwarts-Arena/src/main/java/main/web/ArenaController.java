package main.web;

import main.model.House;
import main.model.Wizard;
import main.service.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/arena")
public class ArenaController {

    private final WizardService wizardService;

    @Autowired
    public ArenaController(WizardService wizardService) {
        this.wizardService = wizardService;
    }

    @GetMapping
    public ModelAndView getArena() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("arena");

        List<Wizard> gryffindorWizards = wizardService.getByHouse(House.GRYFFINDOR);
        List<Wizard> slytherinWizards = wizardService.getByHouse(House.SLYTHERIN);
        List<Wizard> ravenclawWizards = wizardService.getByHouse(House.RAVENCLAW);
        List<Wizard> hufflepuffWizards = wizardService.getByHouse(House.HUFFLEPUFF);

        modelAndView.addObject("gryffindorWizards", gryffindorWizards);
        modelAndView.addObject("slytherinWizards", slytherinWizards);
        modelAndView.addObject("ravenclawWizards", ravenclawWizards);
        modelAndView.addObject("hufflepuffWizards", hufflepuffWizards);



        return modelAndView;
    }
}
