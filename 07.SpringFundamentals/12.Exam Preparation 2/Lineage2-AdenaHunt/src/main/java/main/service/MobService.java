package main.service;

import lombok.extern.slf4j.Slf4j;
import main.model.*;
import main.property.ClassProperties;
import main.property.MobProperties.MobDetail;
import main.repository.MobRepository;
import main.web.dto.FightResult;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@Service
@Slf4j
public class MobService {

    private final MobRepository mobRepository;
    private final PlayerService playerService;

    public MobService(MobRepository mobRepository, PlayerService playerService) {
        this.mobRepository = mobRepository;
        this.playerService = playerService;
    }


    public Mob createMob(MobDetail mob) {

        Random random = new Random();

        double statMultiplier = 1;
        int dropMultiplier = 1;

        MobType type = MobType.values()[random.nextInt(0, MobType.values().length)];

        if (type == MobType.BLUE_CHAMPION) {
            statMultiplier = 1.05;
            dropMultiplier = 2;
        } else if (type == MobType.RED_CHAMPION) {
            statMultiplier = 1.1;
            dropMultiplier = 3;
        }

        int level = random.nextInt(mob.getLevelRange().get(0), mob.getLevelRange().get(1) + 1);

        Mob createdMob = Mob.builder()
                .name(mob.getName())
                .level(level)
                .health(mob.getHealthFactor() * level * statMultiplier)
                .attack(mob.getAttackFactor() * level * statMultiplier)
                .defence(mob.getDefenseFactor() * level * statMultiplier)
                .alive(true)
                .adenaDrop((random.nextInt(mob.getAdenaDrop().get(0), mob.getAdenaDrop().get(1) + 1) * dropMultiplier))
                .xpDrop((random.nextInt(mob.getXpDrop().get(0), mob.getXpDrop().get(1) + 1) * dropMultiplier))
                .mobType(type)
                .imageUrl(mob.getImage())
                .spawnArea(mob.getSpawnArea())
                .description(mob.getDescription())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        return mobRepository.save(createdMob);
    }

    public List<Mob> getLast3Mobs() {

        return mobRepository.getAllByAliveOrderByCreatedOnDesc(true).stream().limit(3).toList();
    }

    public List<Mob> getAllMobs() {

        return mobRepository.findAll();
    }

    public FightResult attack(UUID attackerId, UUID mobId) {

        Player player = playerService.getById(attackerId);
        Mob mob = getById(mobId);

        FightOutcome outcome = executeFight(player, mob);

        if (outcome == FightOutcome.MOB_WIN) {

            return FightResult.builder()
                    .outcome(outcome)
                    .mobName(mob.getName())
                    .xpEarned(0)
                    .adenaEarned(0)
                    .build();
        }

        int xpReward = mob.getXpDrop();
        int adenaReward = mob.getAdenaDrop();

        if (player.getParty() != null) {
            // трябва да наградя всички в партито
            List<Player> members = playerService.findAllByParty(player.getParty());
            xpReward = xpReward / members.size();
            adenaReward = adenaReward / members.size();
            int newXpReward = xpReward;
            int newAdenaReward = adenaReward;
            members.forEach(member -> playerService.rewardPlayer(member, newXpReward, newAdenaReward));
        } else {
            // само аз получавам награда

            playerService.rewardPlayer(player, xpReward, adenaReward);
        }

        mob.setAlive(false);
        mobRepository.save(mob);

        return FightResult.builder()
                .outcome(outcome)
                .mobName(mob.getName())
                .adenaEarned(adenaReward)
                .xpEarned(xpReward)
                .build();
    }

    private FightOutcome executeFight(Player player, Mob mob) {

        double playerHealth = player.getHealth();
        double mobHealth = mob.getHealth();

        List<ClassProperties.ClassDetail.Booster> boosters = playerService.getBoosters(player.getPlayerClass());
        double attackBooster = boosters.stream()
                .filter(boosterAbility -> boosterAbility.getType() == BoosterType.ATTACK_BOOSTER)
                .map(ClassProperties.ClassDetail.Booster::getValue)
                .findFirst()
                .orElse(0.00);
        double defenseBooster = boosters.stream()
                .filter(boosterAbility -> boosterAbility.getType() == BoosterType.ATTACK_BOOSTER)
                .map(ClassProperties.ClassDetail.Booster::getValue)
                .findFirst()
                .orElse(0.00);

        while (playerHealth > 0 && mobHealth > 0) {

            // First: Player attacks mob
            double playerAttackWithBooster = player.getAttack() + (player.getAttack() * attackBooster);
            double damageToMob = Math.floor(Math.max(1, playerAttackWithBooster - (mob.getDefence() * 0.5)));
            mobHealth = Math.max(0, mobHealth - damageToMob);
            log.info("{} deals {} damage to {}. Mob HP: {}",
                    player.getNickname(), (int) damageToMob, mob.getName(), (int) mobHealth);

            // Did the mob die after player's attack?
            if (mobHealth <= 0) {
                log.info("{} killed {} and left with {} HP.", player.getNickname(), mob.getName(), (int) playerHealth);
                return FightOutcome.PLAYER_WIN;
            }

            // Second: Mob attacks player
            double playerDefenseWithBooster = player.getDefence() + (player.getDefence() * defenseBooster);
            double damageToPlayer = Math.floor(Math.max(1, mob.getAttack() - (playerDefenseWithBooster * 0.5)));
            playerHealth = Math.max(0, playerHealth - damageToPlayer);

            // Did the player die after mob's attack?
            if (playerHealth <= 0) {
                log.info("{} is defeated. {} wins with {} HP left.",
                        player.getNickname(), mob.getName(), (int) mobHealth);
                return FightOutcome.MOB_WIN;
            }
        }

        return playerHealth > 0 ? FightOutcome.PLAYER_WIN : FightOutcome.MOB_WIN;
    }


    private Mob getById(UUID mobId) {

        return mobRepository.findById(mobId).orElse(null);
    }
}