package _12_DefiningClasses_Exercise.CarSalesman;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int engines = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> enginesMap = new LinkedHashMap<>();
        for (int i = 0; i < engines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            fillEngine(tokens, enginesMap);
        }

        int cars = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < cars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            fillCars(tokens, carsList, enginesMap);
        }

        carsList.forEach(System.out::println);
    }

    private static void fillCars(String[] tokens, List<Car> carsList, Map<String, Engine> enginesMap) {
        String model = tokens[0];
        Engine engine = enginesMap.get(tokens[1]);
        int weight;
        String color;
        if (tokens.length == 3) {
            boolean isWeight = true;
            try {
                weight = Integer.parseInt(tokens[2]);
                Car car = new Car(model, engine, weight);
                carsList.add(car);
                isWeight = false;
            } catch (NumberFormatException e) {
            }

            if (isWeight) {
                color = tokens[2];
                Car car = new Car(model, engine, color);
                carsList.add(car);
            }
        } else if (tokens.length == 4) {
            weight = Integer.parseInt(tokens[2]);
            color = tokens[3];
            Car car = new Car(model, engine, weight, color);
            carsList.add(car);
        } else {
            Car car = new Car(model, engine);
            carsList.add(car);
        }
    }

    private static void fillEngine(String[] tokens, Map<String, Engine> enginesMap) {

        String model = tokens[0];
        int power = Integer.parseInt(tokens[1]);
        int displacement = -1;
        String efficiency;

        if (tokens.length == 2) {
            Engine engine = new Engine(model, power);
            enginesMap.put(model, engine);
        } else if (tokens.length == 3) {
            try {
                displacement = Integer.parseInt(tokens[2]);
                Engine engine = new Engine(model, power, displacement);
                enginesMap.put(model, engine);
            } catch (NumberFormatException e) {
                efficiency = tokens[2];
                Engine engine = new Engine(model, power, efficiency);
                enginesMap.put(model, engine);
            }
        } else if (tokens.length == 4) {
            efficiency = tokens[3];
            displacement = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(model, power, displacement, efficiency);
            enginesMap.put(model, engine);
        }
    }
}



