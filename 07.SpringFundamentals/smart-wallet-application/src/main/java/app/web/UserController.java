package app.web;

import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.EditProfileRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/profile")
    public ModelAndView getProfilePage(@PathVariable UUID id){

        User user = userService.getById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile-menu");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @GetMapping("/users/{id}/profile")
    public ModelAndView showProfilePage(@PathVariable UUID id){

        User user = userService.getById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile-menu");
        modelAndView.addObject("user", user);
        modelAndView.addObject("editProfileRequest",new EditProfileRequest());

        return modelAndView;
    }

    @PostMapping("/users/{id}/profile")
    public ModelAndView editProfilePage(@PathVariable UUID id, BindingResult bindingResult,@Valid EditProfileRequest editProfileRequest){

        if (bindingResult.hasErrors()){
            return new ModelAndView("profile-menu");
        }

        User user = userService.editProfile(id, editProfileRequest);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/home");
        modelAndView.addObject("user", user);

        return modelAndView;
    }


    @GetMapping
    public ModelAndView getUsers(){

        List<User> all = userService.getAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", all);

        return modelAndView;
    }
}
