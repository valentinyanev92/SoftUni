package _12_ObjectsAndClasses_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private double horsepower;
        private static int carCount = 0;
        private static int truckCount = 0;

        static double truckAverageHorsepower;
        static double carAverageHorsepower;


        public Vehicle(String type, String model, String color, double horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;


            if (type.equals("car")) {
                carAverageHorsepower = carAverageHorsepower + this.horsepower;
                carCount++;
            } else {
                truckAverageHorsepower += this.horsepower;
                truckCount++;
            }
        }

        static String getTruckAverageHorsepower() {
            truckAverageHorsepower /= truckCount;
            return String.format("Trucks have average horsepower of %.2f%n", truckAverageHorsepower);
        }

        static String getCarAverageHorsepower() {
            carAverageHorsepower /= carCount;
            return String.format("Cars have average horsepower of %.2f%n", carAverageHorsepower);
        }

        String getType() {
            return type;
        }

        String getCarInfo() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %.0f%n", type, model, color, horsepower);
        }

        public String getModel() {
            return model;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Vehicle> vehicleList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputArr = input.split(" ");
            Vehicle vehicle = new Vehicle(inputArr[0], inputArr[1], inputArr[2], Double.parseDouble(inputArr[3]));
            vehicleList.add(vehicle);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue")) {
            for (int i = 0; i < vehicleList.size(); i++) {
                if (input.equals(vehicleList.get(i).getModel())) {
                    System.out.println(vehicleList.get(i).getCarInfo());
                }
            }
            input = scanner.nextLine();
        }

        System.out.printf(Vehicle.getCarAverageHorsepower());
        System.out.printf(Vehicle.getTruckAverageHorsepower());
    }
}
