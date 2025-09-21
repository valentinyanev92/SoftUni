package main.web;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/info")
public class MyController {

    private Map<Integer, String> users = Map.of(
            1, "Vik",
            2, "Ivan",
            3, "Boris",
            4, "Vivi",
            5, "Vino",
            6, "Valeri");


    // GET info/users/special?firstLetter=V
    @GetMapping("/users/special")
    public List<String> getUserByFirstLetter(@RequestParam String firstLetter) {
        return users.values().stream().filter(name -> name.startsWith(firstLetter)).toList();
    }

    @GetMapping("/users")
    public Map<Integer, String> getUsers() {
        return users;
    }

    @GetMapping("/users/{userId}")
    public String getUserById(@PathVariable int userId) {
        return users.get(userId);
    }

    @GetMapping("/day")
    public String getDayNow() {
        return "Today is " + LocalDate.now().getDayOfWeek();
    }

    @GetMapping("/date")
    public String getDateNow() {
        return "Date now is " + LocalDate.now();
    }

    @GetMapping("/time")
    public String getTimeNow() {
        return "Time now is " + LocalTime.now();
    }
}
