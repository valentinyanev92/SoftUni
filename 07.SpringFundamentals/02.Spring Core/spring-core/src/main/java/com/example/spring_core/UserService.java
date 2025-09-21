package com.example.spring_core;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void welcomeToUser() {
        System.out.println("Welcome to the application");
    }

    public String getUser(){
        return "Vik";
    }
}
