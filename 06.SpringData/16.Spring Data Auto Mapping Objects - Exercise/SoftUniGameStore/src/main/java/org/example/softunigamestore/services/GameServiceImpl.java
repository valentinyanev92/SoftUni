package org.example.softunigamestore.services;

import org.example.softunigamestore.dtos.GameDto;
import org.example.softunigamestore.entities.Game;
import org.example.softunigamestore.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository repository;
    private final ModelMapper mapper;

    public GameServiceImpl(GameRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }


    @Override
    public GameDto registerGame(GameDto dto) {
        Game game = this.mapper.map(dto, Game.class);
        this.repository.save(game);

        return mapper.map(game, GameDto.class);
    }

    @Override
    public GameDto findGameById(Long id) {
        return mapper.map(repository.findById(id).orElse(null), GameDto.class);
    }

    @Override
    public String deleteGameById(Long id) {
        Game game = this.repository.findById(id).orElse(null);
        if (game != null) {
            this.repository.delete(game);
        }else {
            return String.format("Game with id %s not found", id);
        }
        return String.format("Game %s with ID %d was successfully deleted!", game.getTitle(), game.getId());
    }

    @Override
    public List<GameDto> getAllGames() {
        List<Game> games = this.repository.findAll();
        return games.stream().map(game -> mapper.map(game, GameDto.class)).collect(Collectors.toList());
    }

    @Override
    public GameDto getGameByTitle(String title) {
        return mapper.map(repository.getByTitle(title), GameDto.class);
    }

    @Override
    public Game getById(Long id) {
        return this.repository.findById(id).orElseThrow();
    }
}
