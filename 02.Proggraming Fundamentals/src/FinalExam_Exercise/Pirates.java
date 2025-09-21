package FinalExam_Exercise;

import java.util.*;

public class Pirates {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, List<Integer>> destinations = new LinkedHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split("\\|\\|");

            if (input[0].equals("Sail")) {
                break;
            }

            if (!destinations.containsKey(input[0])) {
                destinations.put(input[0], new ArrayList<>());
                destinations.get(input[0]).add(Integer.parseInt(input[1]));
                destinations.get(input[0]).add(Integer.parseInt(input[2]));
            } else {
                destinations.get(input[0]).set(0, destinations.get(input[0]).get(0) + Integer.parseInt(input[1]));
                destinations.get(input[0]).set(1, destinations.get(input[0]).get(1) + Integer.parseInt(input[2]));
            }
        }

        boolean isActive = true;
        while (isActive) {
            String[] input = scanner.nextLine().split("=>");

            switch (input[0]) {
                case "Plunder" ->
                        Plunder(destinations, input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                case "Prosper" -> Prosper(destinations, input[1], Integer.parseInt(input[2]));
                case "End" -> isActive = false;
            }
        }

        PrintTowns(destinations);
    }

    public static void Plunder(Map<String, List<Integer>> destinations, String town, int people, int gold) {

        destinations.get(town).set(0, destinations.get(town).get(0) - people);
        destinations.get(town).set(1, destinations.get(town).get(1) - gold);
        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

        if (destinations.get(town).get(0) == 0 || destinations.get(town).get(1) == 0) {
            System.out.printf("%s has been wiped off the map!%n", town);
            destinations.remove(town);
        }
    }

    public static void Prosper(Map<String, List<Integer>> destinations, String town, int gold) {

        boolean isValid = true;
        if (gold < 0) {
            System.out.println("Gold added cannot be a negative number!");
            isValid = false;
        }

        if (isValid) {
            destinations.get(town).set(1, destinations.get(town).get(1) + gold);
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, destinations.get(town).get(1));
        }
    }

    public static void PrintTowns(Map<String, List<Integer>> destinations) {

        if (destinations.isEmpty()){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", destinations.size());
            destinations.forEach((key, value) -> {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", key, value.get(0), value.get(1));
            });
        }
    }
}
