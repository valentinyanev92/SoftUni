package _05_SetsAndMapsAdvanced_Lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, ArrayList<String>>> continentMap = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(" ");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continentMap.putIfAbsent(continent, new LinkedHashMap<>());
            continentMap.get(continent).putIfAbsent(country, new ArrayList<>());
            continentMap.get(continent).get(country).add(city);
        }

        continentMap.forEach((key, value) -> {
            System.out.println(key + ":");

            value.forEach((country, towns) -> {
                System.out.print("  " + country + " -> ");

                for (int i = 0; i < towns.size(); i++) {
                    System.out.print(towns.get(i));
                    if (i != towns.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            });
        });

    }
}
