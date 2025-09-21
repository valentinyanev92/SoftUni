package org.example.productshop.dtos.usersAndProducts;

import org.example.productshop.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserCountDTO {

    private int userCount;
    private List<UserCountUserDTO> users;

    public UserCountDTO() {

    }

    public UserCountDTO(List<User> users) {
        this.userCount = users.size();
        this.users = new ArrayList<>();
        for (User user : users) {
            UserCountUserDTO userCountUserDTO = new UserCountUserDTO(user);
            this.users.add(userCountUserDTO);
        }
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
}
