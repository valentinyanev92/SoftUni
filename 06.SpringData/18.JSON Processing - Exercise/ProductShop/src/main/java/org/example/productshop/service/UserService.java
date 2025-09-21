package org.example.productshop.service;

import org.example.productshop.entities.User;

import java.io.IOException;

public interface UserService {

    void importData() throws IOException;
    User getRandomUser();

    void findAllWhoHadSells() throws IOException;

    void getSummary() throws IOException;
}
