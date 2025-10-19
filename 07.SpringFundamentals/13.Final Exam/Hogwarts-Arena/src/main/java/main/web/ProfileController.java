package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Wizard;
import main.service.WizardService;
import main.web.dto.EditProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final WizardService wizardService;

    @Autowired
    public ProfileController(WizardService wizardService) {
        this.wizardService = wizardService;
    }

    @GetMapping
    public ModelAndView getProfile(HttpSession session) {

        Wizard wizard = wizardService.getById((UUID) session.getAttribute("user_id"));
        EditProfileRequest editProfileRequest = EditProfileRequest.builder()
                .username(wizard.getUsername())
                .avatarUrl(wizard.getAvatarUrl())
                .build();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        modelAndView.addObject("editProfileRequest", editProfileRequest);
        modelAndView.addObject("wizard", wizard);


        return modelAndView;
    }

    @PutMapping
    public ModelAndView editProfile(@Valid  EditProfileRequest editProfileRequest, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("profile");
        }

        Wizard wizard = wizardService.getById((UUID) session.getAttribute("user_id"));
        wizardService.update(wizard, editProfileRequest);

        return  new ModelAndView("redirect:/home");
    }

    @PatchMapping("/alignment")
    public String switchAlignment(HttpSession session) {

        Wizard wizard = wizardService.getById((UUID) session.getAttribute("user_id"));
        wizardService.updateAlignment(wizard);

        return "redirect:/home";
    }

}
