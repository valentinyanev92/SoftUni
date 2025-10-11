package main.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class IdentifyTheCallerController {

    @GetMapping
    public String getInfo(HttpServletRequest request) {

        String type = request.getHeader("X-Client-Type");
        if (type == null) {
            type = "Unknown";
        }


        if (type.equals("web")) {
            return "Welcome, web user";
        } else if (type.equals("mobile")) {
            return "Hello from mobile interface";
        } else if (type.equals("admin-panel")) {
            return "Admin access granted.";
        }

        return "Unknown client. Please specify 'X-Client-Type' header.";
    }
}
