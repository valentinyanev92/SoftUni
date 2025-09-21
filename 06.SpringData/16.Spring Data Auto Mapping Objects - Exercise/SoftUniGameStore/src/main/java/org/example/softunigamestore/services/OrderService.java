package org.example.softunigamestore.services;

import jakarta.validation.Valid;
import org.example.softunigamestore.dtos.OrderInputDto;
import org.springframework.validation.annotation.Validated;

@Validated
public interface OrderService{

    void create(@Valid OrderInputDto dto);
}
