package org.example.softunigamestore.services;

import jakarta.validation.Valid;
import org.example.softunigamestore.dtos.UserDto;
import org.example.softunigamestore.dtos.UserLoginDto;
import org.example.softunigamestore.dtos.UserRegisterDto;
import org.example.softunigamestore.entities.User;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {
    UserDto ensureAdmin(@Valid UserRegisterDto dto);
    UserDto register(@Valid UserRegisterDto dto);
    UserDto login(UserLoginDto dto);

    User getById(Long id);
}
