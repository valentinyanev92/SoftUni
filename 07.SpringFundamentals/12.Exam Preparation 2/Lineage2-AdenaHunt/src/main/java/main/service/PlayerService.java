package main.service;

import main.exeption.DomainException;
import main.model.BoosterType;
import main.model.Party;
import main.model.Player;
import main.model.PlayerClass;
import main.property.ClassProperties;
import main.property.ClassProperties.ClassDetail.Booster;
import main.repository.PlayerRepository;
import main.web.dto.ClassRequest;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClassProperties classProperties;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PasswordEncoder passwordEncoder, ClassProperties classProperties) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
        this.classProperties = classProperties;
    }

    public Player registerUser(RegisterRequest registerRequest) {

        Player player = Player.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .nickname(registerRequest.getNickname())
                .level(1)
                .xp(100)
                .adena(0)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        return playerRepository.save(player);
    }

    public Player login(LoginRequest loginRequest) {

        Optional<Player> player = playerRepository.findByUsername(loginRequest.getUsername());
        if (player.isEmpty() || !passwordEncoder.matches(loginRequest.getPassword(), player.get().getPassword())) {
            throw new DomainException("Invalid username or password");
        }

        return player.get();
    }

    public Player getById(UUID uuid) {
        return playerRepository.findById(uuid).orElseThrow(() -> new DomainException("Player not found"));
    }

    public Player choiceClass(Player player, ClassRequest classRequest) {

        List<ClassProperties.ClassDetail> currentClasses = classProperties.getClasses().stream().filter(classDetail ->
                classDetail.getPlayerClass().equals(classRequest.getPlayerClass())).toList();

        player.setPlayerClass(currentClasses.get(0).getPlayerClass());
        player.setBannerImg(currentClasses.get(0).getBannerImg());
        player.setAttack((double) (player.getLevel() * currentClasses.get(0).getAttackFactor()));
        player.setDefence((double) (player.getLevel() * currentClasses.get(0).getDefenseFactor()));
        player.setHealth((double) (player.getLevel() * currentClasses.get(0).getHealthFactor()));

        return playerRepository.save(player);
    }

    public List<Booster> getBoosters(PlayerClass playerClass) {

        return classProperties.getDetailsByPlayerClass(playerClass).getBoosters();
    }


    public List<Player> findAllByParty(Party party) {

        return playerRepository.findByParty(party);
    }

    public void update(Player player) {

        playerRepository.save(player);
    }

    public List<Player> findAll() {

        return playerRepository.findAll();
    }

    public void rewardPlayer(Player player, int xpReward, int adenaReward) {

        List<Booster> boosters = getBoosters(player.getPlayerClass());
        double xpBooster = boosters.stream()
                .filter(boosterAbility -> boosterAbility.getType() == BoosterType.XP_BOOSTER)
                .map(Booster::getValue)
                .findFirst()
                .orElse(0.00);
        double adenaBooster = boosters.stream()
                .filter(boosterAbility -> boosterAbility.getType() == BoosterType.ADENA_BOOSTER)
                .map(Booster::getValue)
                .findFirst()
                .orElse(0.00);

        double finalXp = xpReward + (xpReward * xpBooster);
        double finalAdena = adenaReward + (adenaReward * adenaBooster);

        player.setXp((int) (player.getXp() + finalXp));
        player.setAdena((int) (player.getAdena() + finalAdena));

        levelUp(player);
        playerRepository.save(player);
    }

    private void levelUp(Player player) {
        int newLevel = (int) player.getXp() / 100;

        if (newLevel > player.getLevel()) {

            player.setLevel(newLevel);
            ClassProperties.ClassDetail classDetails = classProperties.getDetailsByPlayerClass(player.getPlayerClass());

            player.setHealth((double) (classDetails.getHealthFactor() * newLevel));
            player.setAttack((double) (classDetails.getAttackFactor() * newLevel));
            player.setDefence((double) (classDetails.getDefenseFactor() * newLevel));

            player.setUpdatedOn(LocalDateTime.now());
        }
    }
}
