package main.repository;

import main.model.Player;
import main.model.PlayerClass;
import main.model.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestRepository extends JpaRepository<Quest, UUID> {
    List<Quest> findAllByEligibleClassOrderByCreatedOnDesc(PlayerClass eligibleClass);

    List<Quest> findAllByCapturer(Player capturer);

    List<Quest> findAllByOrderByCreatedOnDescXpDesc();

    Quest getQuestById(UUID questId);
}
