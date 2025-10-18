package main.web;

import jakarta.servlet.http.HttpSession;
import main.service.PartyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/party")
public class PartyController {

    private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @PostMapping()
    public String invite(@RequestParam("receiverId") UUID receiverId, HttpSession session) {

        UUID senderId = (UUID) session.getAttribute("user_id");
        partyService.invitePlayer(senderId, receiverId);

        return  "redirect:/lobby";
    }

    @DeleteMapping("/{partyId}")
    public String dismiss(@PathVariable UUID partyId) {

        partyService.dismissParty(partyId);

        return  "redirect:/lobby";
    }
}
