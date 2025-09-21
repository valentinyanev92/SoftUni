package com.example.spring_core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private UserService userService;

    @Autowired
    public PaymentService(UserService userService) {
        this.userService = userService;
    }

    public void makePayment(){
        System.out.println("Charging user - " + userService.getUser());
    }
}
