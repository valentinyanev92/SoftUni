package main.service;

import jakarta.validation.Valid;
import main.model.Item;
import main.model.Player;
import main.model.Quest;
import main.repository.QuestRepository;
import main.web.dto.QuestRequest;
import main.web.dto.QuestUploadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class QuestService {

    private final QuestRepository questRepository;
    private final ItemService itemService;

    @Autowired
    public QuestService(QuestRepository questRepository, ItemService itemService) {
        this.questRepository = questRepository;
        this.itemService = itemService;
    }

    public int getQuestsCount() {
        List<Quest> questList = questRepository.findAll();
        return questList.size();
    }

    public List<Quest> getAllAvailableQuestsForCurrentPlayer(Player player) {
        return questRepository.findAllByEligibleClassOrderByCreatedOnDesc(player.getPlayerClass());
    }

    public List<Quest> getAllCompletedQuestsByUser(Player player) {
        return questRepository.findAllByCapturer(player);
    }

    public List<Quest> getAll() {

//        return questRepository.findAll(Sort.by(Sort.Direction.DESC, "createdOn", "xp"));
        return questRepository.findAllByOrderByCreatedOnDescXpDesc();
    }

    public Quest uploadQuest(QuestUploadRequest questUploadRequest, Player player) {

        Item rewardItem = itemService.getById(questUploadRequest.getItemId());

        Quest quest = Quest.builder()
                .title(questUploadRequest.getTitle())
                .description(questUploadRequest.getDescription())
                .xp(questUploadRequest.getXp())
                .bannerUrl(questUploadRequest.getBannerUrl())
                .eligibleClass(questUploadRequest.getPlayerClass())
                .rewardItem(rewardItem)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .createdBy(player.getNickname())
                .updatedBy(player.getNickname())
                .build();

        return questRepository.save(quest);
    }

    public Quest getQuestById(QuestRequest questRequest) {
        return questRepository.getQuestById(UUID.fromString(questRequest.getQuestId()));
    }
}
