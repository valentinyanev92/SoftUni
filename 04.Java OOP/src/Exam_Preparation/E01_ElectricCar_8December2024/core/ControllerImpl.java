package Exam_Preparation.E01_ElectricCar_8December2024.core;

//TODO - Implement all the methods

import Exam_Preparation.E01_ElectricCar_8December2024.entities.car.*;
import Exam_Preparation.E01_ElectricCar_8December2024.entities.competition.Competition;
import Exam_Preparation.E01_ElectricCar_8December2024.entities.competition.CompetitionImpl;
import Exam_Preparation.E01_ElectricCar_8December2024.entities.destination.Destination;
import Exam_Preparation.E01_ElectricCar_8December2024.entities.destination.Lake;
import Exam_Preparation.E01_ElectricCar_8December2024.entities.destination.Mountain;
import Exam_Preparation.E01_ElectricCar_8December2024.entities.destination.SeaSide;
import Exam_Preparation.E01_ElectricCar_8December2024.entities.repositories.DestinationRepository;
import Exam_Preparation.E01_ElectricCar_8December2024.entities.repositories.Repository;

import java.util.Collection;
import java.util.List;

import static Exam_Preparation.E01_ElectricCar_8December2024.common.ConstantMessages.*;
import static Exam_Preparation.E01_ElectricCar_8December2024.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final Repository<Destination> destinationRepository;

    public ControllerImpl() {
        this.destinationRepository = new DestinationRepository();
    }


    @Override
    public String addDestination(String destinationType, String destinationName) {

        Destination destination;
        switch (destinationType){
            case "Mountain" -> destination = new Mountain(destinationName);
            case "Lake" -> destination = new Lake(destinationName);
            case "SeaSide" -> destination = new SeaSide(destinationName);
            default -> throw new IllegalArgumentException(INVALID_DESTINATION);
        }

        Destination destinationCheck = destinationRepository.byName(destinationName);
        if (destinationCheck != null) {
            throw new IllegalArgumentException(EXISTING_DESTINATION);
        }

        destinationRepository.add(destination);
        return String.format(DESTINATION_ADDED, destinationType, destinationName);
    }

    @Override
    public String addCar(String destinationName, String carBrand, String carModel) {

        Destination destination = destinationRepository.byName(destinationName);
        if (destination == null) {
            throw new IllegalArgumentException(NON_EXISTING_DESTINATION);
        }

        Collection<Car> carCheck = destination.getCars();
        carCheck.forEach(check -> {
            if (carModel.equals(check.getModel())) {
                throw new IllegalArgumentException(EXISTING_CAR_BRAND_AND_MODEL);
            }
        });

        Car car;
        switch (carBrand){
            case "Hyundai" -> car = new Hyundai(carModel);
            case "Dacia" -> car = new Dacia(carModel);
            case "Tesla" -> car = new Tesla(carModel);
            case "VW" -> car = new VW(carModel);
            default -> throw new IllegalArgumentException(INVALID_CAR);
        }

        return String.format(CAR_ADDED, carBrand, carModel);
    }

    @Override
    public String reachDestination(String destinationName) {

        Destination destination = destinationRepository.byName(destinationName);

        Collection<Car> cars = destination.getCars();

        StringBuilder build = new StringBuilder();

        Competition competition = new CompetitionImpl();
        competition.startVoyage(destination, cars);

        List<Car> unfinishedCars = getUnfinishedCars(destination);
        build.append(String.format(VOYAGE_OVER, destinationName, unfinishedCars.size()));

        return build.toString();
    }

    private static List<Car> getUnfinishedCars(Destination destination) {
        return destination.getCars().stream()
                .filter(car -> (car.getMileage() < destination.getDistance() && car.getBatteryCapacity() <= 0)
                        || (car.getMileage() < destination.getDistance() && car.getBatteryCapacity() < 15))
                .toList();
    }

    private static void extracted(Car car, StringBuilder build) {

        build.append(String.format(FINAL_CAR_INFO,
                car.getClass().getSimpleName(),
                car.getModel(),
                car.getBatteryCapacity(),
                car.getMileage())).append(System.lineSeparator());
    }



    @Override
    public String getStatistics() {

        StringBuilder build = new StringBuilder();
        Collection<Destination> destinations = destinationRepository.getCollection();

        for (Destination destination : destinations) {
            build.append(String.format(CARS_TOOK_PART, destination.getName())).append(System.lineSeparator());
            for (Car car : destination.getCars()) {
                extracted(car, build);
            }
        }
        return build.toString();
    }
}
