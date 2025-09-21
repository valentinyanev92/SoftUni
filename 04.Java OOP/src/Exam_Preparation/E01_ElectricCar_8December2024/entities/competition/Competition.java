package Exam_Preparation.E01_ElectricCar_8December2024.entities.competition;

import Exam_Preparation.E01_ElectricCar_8December2024.entities.car.Car;
import Exam_Preparation.E01_ElectricCar_8December2024.entities.destination.Destination;

import java.util.Collection;

public interface Competition {

    void startVoyage(Destination destination, Collection<Car> cars);
}
