package main.web;

import main.model.User;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //MVC
@RequestMapping("/info2")
public class MySecondController {

    public final UserService userService;

    @Autowired
    public MySecondController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ModelAndView getUserDetails() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("age", 62);
        modelAndView.addObject("city", "Stara Zagora");

        modelAndView.setViewName("info");


        return modelAndView;
    }

    @GetMapping("/user/{id}")
    public ModelAndView getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name", user.getFirstName());
        modelAndView.addObject("id", user.getId());

        modelAndView.setViewName("info");
        return modelAndView;
    }
}
