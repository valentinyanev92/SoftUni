package org.example.car_dealer.service;

import org.example.car_dealer.entities.Customer;

import java.io.IOException;

public interface CustomerService {
    void importData() throws IOException;

    Customer getRandomCustomer();
    void getXmlForAllCustomers() throws IOException;
}
