package com.example.spring_core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype") // Дали да има нова инстанция при извикване от ApplicationContext
public class OrderService {

    @Autowired
    public UserService userService;

//    @Autowired
//    public OrderService(UserService userService) {
//        this.userService = userService;
//    }

    public void makeOrder(){
        System.out.println("Ordering user - " + userService.getUser());
    }
}
