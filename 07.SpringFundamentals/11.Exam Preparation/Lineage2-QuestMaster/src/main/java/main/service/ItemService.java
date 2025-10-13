package main.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import main.model.Item;
import main.model.Player;
import main.repository.ItemRepository;
import main.web.dto.ItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public int getItemsCount() {

        List<Item> itemList = itemRepository.findAll();
        return itemList.size();
    }

    @Transactional
    public Item addItem(@Valid ItemRequest itemRequest, Player player) {

        Item item = Item.builder()
                .name(itemRequest.getName())
                .type(itemRequest.getType())
                .xpBonusMultiplier(itemRequest.getXpBonusMultiplier())
                .iconUrl(itemRequest.getIconUrl())
                .createdBy(player.getUsername())
                .updatedBy(player.getUsername())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        return itemRepository.save(item);
    }

    public List<Item> getAll() {

        return itemRepository.findAll(Sort.by(Sort.Direction.DESC, "createdOn", "xpBonusMultiplier"));
    }

    public Item getById(String itemId) {
        return itemRepository.getItemById(UUID.fromString(itemId));
    }
}
