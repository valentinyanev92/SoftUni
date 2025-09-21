package org.example.softunigamestore.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ShoppingCartItemInputDto {
    @NotNull
    private final Long userId;

    @NotNull
    private final Long gameId;

    @NotNull
    @Positive
    private final int quantity;

    public ShoppingCartItemInputDto(Long userId, Long gameId, int quantity) {
        this.userId = userId;
        this.gameId = gameId;
        this.quantity = quantity;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public int getQuantity() {
        return quantity;
    }
}
