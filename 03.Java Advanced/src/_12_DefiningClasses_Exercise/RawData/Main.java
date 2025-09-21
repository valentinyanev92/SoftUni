package _12_DefiningClasses_Exercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            addCar(tokens, cars);
        }

        String command = scanner.nextLine();
        switch (command){
            case "fragile" -> printFragile(cars);
            case "flamable" -> printFlamable(cars);
        }


    }

    private static void printFlamable(List<Car> cars) {
        cars.forEach( car -> {
            if (car.getCargoType().equals("flamable")) {
                if (car.getEnginePower() > 250){
                    System.out.println(car.toString());
                }
            }
        });
    }

    private static void printFragile(List<Car> cars) {
        cars.forEach( car -> {
            if (car.getCargoType().equals("fragile")) {
                List<Tyre> tyreList = car.getTyres();

                boolean isValid = false;
                for (Tyre tyre : tyreList) {
                    if (tyre.getPressure() < 1){
                        isValid = true;
                    }else {
                        break;
                    }
                }

                if (isValid) {
                    System.out.println(car.toString());
                }
            }
        });




    }

    private static void addCar(String[] tokens, List<Car> cars) {
        String model = tokens[0];
        int engineSpeed = Integer.parseInt(tokens[1]);
        int enginePower = Integer.parseInt(tokens[2]);
        int cargoWeight = Integer.parseInt(tokens[3]);
        String cargoType = tokens[4];

        double tyre1Pressure = Double.parseDouble(tokens[5]);
        int tyre1Age = Integer.parseInt(tokens[6]);
        double tyre2Pressure = Double.parseDouble(tokens[7]);
        int tyre2Age = Integer.parseInt(tokens[8]);
        double tyre3Pressure = Double.parseDouble(tokens[9]);
        int tyre3Age = Integer.parseInt(tokens[10]);
        double tyre4Pressure = Double.parseDouble(tokens[11]);
        int tyre4Age = Integer.parseInt(tokens[12]);

        List<Tyre> tyreList = new ArrayList<>();
        Tyre tyre1 = new Tyre(tyre1Pressure, tyre1Age);
        tyreList.add(tyre1);
        Tyre tyre2 = new Tyre(tyre2Pressure, tyre2Age);
        tyreList.add(tyre2);
        Tyre tyre3 = new Tyre(tyre3Pressure, tyre3Age);
        tyreList.add(tyre3);
        Tyre tyre4 = new Tyre(tyre4Pressure, tyre4Age);
        tyreList.add(tyre4);

        Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType,tyreList);
        cars.add(car);
    }
}
