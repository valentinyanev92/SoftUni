package main.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import main.model.Player;
import main.model.PlayerClass;
import main.model.PlayerRole;
import main.model.Quest;
import main.repository.PlayerRepository;
import main.repository.QuestRepository;
import main.web.dto.LoginRequest;
import main.web.dto.QuestRequest;
import main.web.dto.RegisterRequest;
import main.web.dto.RoleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class PlayerService {



    private final PlayerRepository playerRepository;
    private final QuestRepository questRepository;
    private final PasswordEncoder passwordEncoder;
    private final QuestService questService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, QuestRepository questRepository, PasswordEncoder passwordEncoder, QuestService questService) {
        this.playerRepository = playerRepository;
        this.questRepository = questRepository;
        this.passwordEncoder = passwordEncoder;
        this.questService = questService;
    }

    @Transactional
    public Player register(RegisterRequest registerRequest) {

        Optional<Player> playerByUsername = playerRepository.findByUsername(registerRequest.getUsername());
        Optional<Player> playerByNickname = playerRepository.findByNickname(registerRequest.getNickname());

        if (playerByUsername.isPresent()){
            throw new RuntimeException("Player with username [%s] already exists".formatted(registerRequest.getUsername()));
        } else if (playerByNickname.isPresent()){
            throw new RuntimeException("Player with nickname [%s] already exists".formatted(registerRequest.getNickname()));
        }


        Player player = Player.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .nickname(registerRequest.getNickname())
                .xp(0.00)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        return playerRepository.save(player);
    }

    public Player login(LoginRequest loginRequest) {

        Optional<Player> player = playerRepository.findByUsername(loginRequest.getUsername());
        if (player.isEmpty() || !passwordEncoder.matches(loginRequest.getPassword(), player.get().getPassword())){
            throw new RuntimeException("Username or password is incorrect");
        }

        return player.get();
    }

    public Player getById(UUID playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player with id [%s] not found".formatted(playerId)));
    }

    public Player setRole(Player player, RoleRequest roleRequest) {

        player.setRole(roleRequest.getRole());
        if (player.getRole() == PlayerRole.ADVENTURER){

            int random = new Random().nextInt(3);
            PlayerClass playerClass;
            if (random == 0){
                playerClass = PlayerClass.DOOMBRINGER;
            }else if (random == 1){
                playerClass = PlayerClass.GHOST_HUNTER;
            }else {
                playerClass = PlayerClass.MYSTIC_MUSE;
            }
            player.setPlayerClass(playerClass);
        }
        player.setUpdatedOn(LocalDateTime.now());

        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {

        return playerRepository.findAll();
    }

    public Quest getQuest(QuestRequest questRequest, Player player) {

        Quest quest = questService.getQuestById(questRequest);
        quest.setCapturer(player);
        quest.setUpdatedOn(LocalDateTime.now());

//        double xp = quest.getXp() * quest.getRewardItem().getXpBonusMultiplier();
        double xp = Math.round(quest.getXp() * quest.getRewardItem().getXpBonusMultiplier());
        player.setXp(player.getXp() + xp);
        player.setUpdatedOn(LocalDateTime.now());
        playerRepository.save(player);

        return questRepository.save(quest);
    }
}
