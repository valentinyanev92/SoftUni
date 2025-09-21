package _10_Polymorphism_Exercises.P02_VehiclesExtension;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        String[] busInfo = scanner.nextLine().split("\\s+");

        Vehicles car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Vehicles truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        Vehicles bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        int commands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commands; i++) {
            String[] commandInfo = scanner.nextLine().split("\\s+");

            String command = commandInfo[0];
            String vehicleType = commandInfo[1];
            double value = Double.parseDouble(commandInfo[2]);

            switch (command) {
                case "DriveEmpty" -> bus.driveEmpty(value);
                case "Drive" -> {
                    if (vehicleType.equals("Car")) {
                        car.drive(value);
                    } else if (vehicleType.equals("Truck")) {
                        truck.drive(value);
                    }else if (vehicleType.equals("Bus")) {
                        bus.drive(value);
                    }
                }
                case "Refuel" -> {
                    if (vehicleType.equals("Car")) {
                        car.refuel(value);
                    } else if (vehicleType.equals("Truck")) {
                        truck.refuel(value);
                    }else if (vehicleType.equals("Bus")) {
                        bus.refuel(value);
                    }
                }
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
