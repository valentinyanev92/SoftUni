package org.example.softunigamestore.services;

import org.example.softunigamestore.dtos.ShoppingCartDto;
import org.example.softunigamestore.dtos.ShoppingCartItemInputDto;
import org.example.softunigamestore.entities.Game;
import org.example.softunigamestore.entities.ShoppingCart;
import org.example.softunigamestore.entities.User;
import org.example.softunigamestore.repositories.ShoppingCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
    private final GameService gameService;
    private final UserService userService;

    private final ShoppingCartRepository shoppingCartRepository;
    private final ModelMapper mapper;


    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ModelMapper mapper, GameService gameService, UserService userService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.mapper = mapper;
        this.gameService = gameService;
        this.userService = userService;
    }

    @Override
    public ShoppingCartDto create(ShoppingCartItemInputDto dto) {
        User user = this.userService.getById(dto.getUserId());
        Game game = this.gameService.getById(dto.getGameId());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCart.setGame(game);
        shoppingCart.setQuantity(dto.getQuantity());

        this.shoppingCartRepository.save(shoppingCart);
        return this.mapper.map(shoppingCart, ShoppingCartDto.class);
    }

    @Override
    public List<ShoppingCart> getForUser(long userId) {
        return shoppingCartRepository.findAllByUserId(userId);
    }

    @Override
    public void clearForUser(long userId) {
        this.shoppingCartRepository.removeAllByUserId(userId);
    }
}
