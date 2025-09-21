package Exam_Preparation.E01_ElectricCar_8December2024.core;

public interface Controller {

    String addDestination(String destinationType, String destinationName);
    String addCar(String destinationName, String carBrand, String carModel);
    String reachDestination(String destinationName);
    String getStatistics();
}
