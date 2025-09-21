package org.example.softunigamestore.services;

import org.example.softunigamestore.dtos.UserDto;
import org.example.softunigamestore.dtos.UserLoginDto;
import org.example.softunigamestore.dtos.UserRegisterDto;
import org.example.softunigamestore.entities.User;
import org.example.softunigamestore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;


    public UserServiceImpl(UserRepository repository, ModelMapper configureModelMapper) {
        this.repository = repository;
        this.mapper = configureModelMapper;
    }

    @Override
    public UserDto ensureAdmin(UserRegisterDto dto) {
        User admin = mapper.map(dto, User.class);
        admin.setAdmin(true);

        try {
            repository.save(admin);
            return this.mapper.map(admin, UserDto.class);
        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }

    @Override
    public UserDto register(UserRegisterDto dto) {
        User newUser = mapper.map(dto, User.class);
        newUser.setAdmin(false);

        repository.save(newUser);
        return this.mapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto login(UserLoginDto dto) {
        User user = this.repository.findAllByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user == null) return null;

        return this.mapper.map(user, UserDto.class);
    }

    @Override
    public User getById(Long id) {
        return this.repository.findById(id).orElseThrow();
    }
}