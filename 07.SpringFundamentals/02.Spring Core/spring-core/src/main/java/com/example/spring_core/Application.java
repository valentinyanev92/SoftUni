package com.example.spring_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        UserService userServiceBean = applicationContext.getBean(UserService.class);
        userServiceBean.welcomeToUser();

        PaymentService paymentServiceBean = applicationContext.getBean(PaymentService.class);
        paymentServiceBean.makePayment();

        OrderService orderServiceBean = applicationContext.getBean(OrderService.class);
        orderServiceBean.makeOrder();

        System.out.println();
    }

}
