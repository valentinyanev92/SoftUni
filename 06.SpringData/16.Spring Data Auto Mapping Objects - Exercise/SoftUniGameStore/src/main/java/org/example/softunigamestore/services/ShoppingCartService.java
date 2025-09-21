package org.example.softunigamestore.services;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.example.softunigamestore.dtos.ShoppingCartDto;
import org.example.softunigamestore.dtos.ShoppingCartItemInputDto;
import org.example.softunigamestore.entities.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCartDto create(@Valid ShoppingCartItemInputDto dto);
    List<ShoppingCart> getForUser(@NotNull long userId);
    void clearForUser(@NotNull long userId);
}
