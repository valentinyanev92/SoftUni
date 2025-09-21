package Exam_Preparation.E01_ElectricCar_8December2024.entities.competition;

import Exam_Preparation.E01_ElectricCar_8December2024.entities.car.Car;
import Exam_Preparation.E01_ElectricCar_8December2024.entities.destination.Destination;

import java.util.Collection;

public class CompetitionImpl implements Competition {


    @Override
    public void startVoyage(Destination destination, Collection<Car> cars) {

        for (Car car : cars) {
            while (car.getMileage() < destination.getDistance()) {
                if (car.getBatteryCapacity() < 15 || car.getBatteryCapacity() <= 0) {
                    break;
                }
                car.drive();
            }
        }
    }
}
