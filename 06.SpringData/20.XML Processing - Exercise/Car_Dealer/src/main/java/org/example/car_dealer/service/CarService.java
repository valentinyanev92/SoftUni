package org.example.car_dealer.service;

import org.example.car_dealer.entities.Car;

import java.io.IOException;

public interface CarService {
    void importData() throws IOException;
    Car getRandomCar();
}
