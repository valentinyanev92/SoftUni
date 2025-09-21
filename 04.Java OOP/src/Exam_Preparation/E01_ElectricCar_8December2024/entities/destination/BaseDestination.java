package Exam_Preparation.E01_ElectricCar_8December2024.entities.destination;

import Exam_Preparation.E01_ElectricCar_8December2024.entities.car.Car;

import java.util.ArrayList;
import java.util.Collection;

public class BaseDestination implements Destination {

    private String name;
    private int distance;
    private Collection<Car> cars;

    public BaseDestination(String destination, int distance) {
        this.cars = new ArrayList<>();
        this.setName(destination);
        this.setDistance(distance);
    }

    public void setName(String name) {
        if (name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setDistance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be a negative number!");
        }
        this.distance = distance;
    }

    @Override
    public Collection<Car> getCars() {
        return cars;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return distance;
    }


}
