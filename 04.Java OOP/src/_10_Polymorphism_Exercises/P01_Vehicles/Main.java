package _10_Polymorphism_Exercises.P01_Vehicles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");

        Vehicles car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Vehicles truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int commands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commands; i++) {
            String[] commandInfo = scanner.nextLine().split("\\s+");

            String command = commandInfo[0];
            String vehicleType = commandInfo[1];
            double value = Double.parseDouble(commandInfo[2]);

            switch (command) {
                case "Drive" -> {
                    if (vehicleType.equals("Car")) {
                        car.drive(value);
                    } else {
                        truck.drive(value);
                    }
                }
                case "Refuel" -> {
                    if (vehicleType.equals("Car")) {
                        car.refuel(value);
                    } else {
                        truck.refuel(value);
                    }
                }
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
