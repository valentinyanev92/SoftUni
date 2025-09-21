package org.example.softunigamestore.dtos;

import jakarta.validation.constraints.NotNull;

public class OrderInputDto {

    @NotNull
    private final long id;

    public OrderInputDto(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
