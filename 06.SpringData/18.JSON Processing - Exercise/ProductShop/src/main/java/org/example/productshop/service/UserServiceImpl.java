package org.example.productshop.service;

import com.google.gson.Gson;
import org.example.productshop.dtos.UserInputDTO;
import org.example.productshop.dtos.UserSalesDTO;
import org.example.productshop.dtos.usersAndProducts.UserCountDTO;
import org.example.productshop.entities.User;
import org.example.productshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private final Gson gson;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Gson gson, ModelMapper mapper) {
        this.mapper = mapper;
        this.gson = gson;
        this.userRepository = userRepository;
    }

    @Override
    public void importData() throws IOException {
        Path path = Path.of("src/main/resources/jsons/users.json");
        List<String> json = Files.readAllLines(path);

        UserInputDTO[] fromJson = gson.fromJson(String.join("", json), UserInputDTO[].class);
        for (UserInputDTO userInputDTO : fromJson) {
            if (userInputDTO.getLastName() == null || userInputDTO.getLastName().length() < 3) {
                System.out.println("User cannot be without last name");
                continue;
            }


            User user = mapper.map(userInputDTO, User.class);
            userRepository.save(user);
        }
    }

    @Override
    public User getRandomUser() {
        long total = userRepository.count();
        Random random = new Random();

        if (total == 0){
            return null;
        }

        long randomId = random.nextLong(total) + 1;
        while (true) {
            Optional<User> user = userRepository.findById(randomId);

            if (user.isPresent()) {
                return user.get();
            }
        }
    }

    @Override
    public void findAllWhoHadSells() throws IOException {
//        List<User> users = userRepository.findAllBySellingNotNullOrderByLastNameAscFirstNameAsc();
        List<User> users = userRepository.findAllBySellingNotEmptyOrderByLastNameAscFirstNameAsc();

        List<UserSalesDTO> result = new ArrayList<>();
        for (User user : users) {
            result.add(new UserSalesDTO(user));
        }

        String json = gson.toJson(result);

        Path path = Path.of("src/main/resources/jsons/result/usersWithSales.json");
        Files.write(path, json.getBytes());

    }

    @Override
    public void getSummary() throws IOException {
        List<User> all = userRepository.getAll();

        UserCountDTO userCountDTO = new UserCountDTO(all);

        String json = gson.toJson(userCountDTO);
        Path path = Path.of("src/main/resources/jsons/result/summary.json");
        Files.write(path, json.getBytes());
    }
}
