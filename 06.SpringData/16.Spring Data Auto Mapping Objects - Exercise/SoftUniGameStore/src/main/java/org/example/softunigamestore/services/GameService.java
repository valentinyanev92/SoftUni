package org.example.softunigamestore.services;

import jakarta.validation.Valid;
import org.example.softunigamestore.dtos.GameDto;
import org.example.softunigamestore.entities.Game;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface GameService {
    GameDto registerGame(@Valid GameDto dto);
    GameDto findGameById(Long id);
    String deleteGameById(Long id);
    List<GameDto> getAllGames();
    GameDto getGameByTitle(String title);

    Game getById(Long id);
}
