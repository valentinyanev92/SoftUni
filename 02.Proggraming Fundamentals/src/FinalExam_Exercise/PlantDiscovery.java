package FinalExam_Exercise;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantsRarity = new LinkedHashMap<>();
        Map<String, List<Integer>> plantsRating = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");
            plantsRarity.putIfAbsent(input[0], 0);
            plantsRarity.replace(input[0], plantsRarity.get(input[0]) + Integer.parseInt(input[1]));
            plantsRating.put(input[0], new ArrayList<>());
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Exhibition")) {
                break;
            }

            String[] operation = input.split(":"); //[0] - type
            String[] flower = input.split(" "); //[1] - flower \ [3] - value

            switch (operation[0]) {
                case "Rate":
                    if (plantsRating.containsKey(flower[1])) {
                        plantsRating.get(flower[1]).add(Integer.parseInt(flower[3]));
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    if (plantsRarity.containsKey(flower[1])) {
                        plantsRarity.replace(flower[1], Integer.parseInt(flower[3]));
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if (plantsRating.containsKey(flower[1])) {
                        plantsRating.replace(flower[1], new ArrayList<>());
                    } else {
                        System.out.println("error");
                    }
                    break;
            }
        }

        System.out.println("Plants for the exhibition:");
        plantsRarity.forEach((key, value) -> {
            System.out.printf("- %s; Rarity: %d; Rating: ", key, value);
            double averageRating = plantsRating.get(key).stream().mapToDouble(flowerRating -> flowerRating).sum() / plantsRating.get(key).size();
            Double d = new Double(averageRating);
            if (d.isNaN()) {
                System.out.printf("0.00%n");
            } else {
                System.out.printf("%.2f%n", averageRating);
            }
        });
    }
}
