package Exam_Preparation.E01_ElectricCar_8December2024.entities.destination;

import Exam_Preparation.E01_ElectricCar_8December2024.entities.car.Car;

import java.util.Collection;

public interface Destination {

    Collection<Car> getCars();

    String getName();

    int getDistance();
}
