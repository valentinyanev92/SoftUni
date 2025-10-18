package main.service;

import main.exeption.DomainException;
import main.model.Party;
import main.model.Player;
import main.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PartyService {

    private final PlayerService playerService;
    private final PartyRepository partyRepository;

    @Autowired
    public PartyService(PlayerService playerService, PartyRepository partyRepository) {
        this.playerService = playerService;
        this.partyRepository = partyRepository;
    }

    public void invitePlayer(UUID senderId, UUID receiverId) {

        Player sender = playerService.getById(senderId);
        Player receiver = playerService.getById(receiverId);

        if (receiver.getParty() != null) {
            throw new DomainException("Receiver already has a party!");
        }

        Party party = sender.getParty();
        if (party == null) {
            party = createParty(sender);
            sender.setParty(party);
            playerService.update(sender);
        }

        List<Player> partyPlayers = playerService.findAllByParty(party);
        if (partyPlayers.size() == 3) {
            throw new DomainException("You cannot invite more than 3 players!");
        }

        receiver.setParty(party);
        playerService.update(receiver);

    }

    private Party createParty(Player sender) {

        Party party = Party.builder()
                .leader(sender)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        return partyRepository.save(party);
    }


    public void dismissParty(UUID partyId) {

        Party party = partyRepository.findById(partyId).orElseThrow(() -> new DomainException("Party not found."));

        party.setUpdatedOn(LocalDateTime.now());

        List<Player> members = playerService.findAllByParty(party);

        members.forEach(member -> {
            member.setParty(null);
            playerService.update(member);
        });

        partyRepository.save(party);
    }
}
