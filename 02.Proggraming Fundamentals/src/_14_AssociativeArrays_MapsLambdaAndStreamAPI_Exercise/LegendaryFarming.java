package _14_AssociativeArrays_MapsLambdaAndStreamAPI_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>();
        String item;

        while (true) {
            String[] input = scanner.nextLine().split(" ");

            for (int i = 1; i < input.length; i++) {
                if (i % 2 == 1) {
                    if (materials.containsKey(input[i].toLowerCase())) {
                        materials.put(input[i].toLowerCase(), materials.get(input[i].toLowerCase()) + Integer.parseInt(input[i - 1]));
                    } else {
                        materials.put(input[i].toLowerCase(), Integer.parseInt(input[i - 1]));
                    }
                }
            }

            if (materials.containsKey("shards")) {
                if (materials.get("shards") >= 250) {
                    materials.put("shards", materials.get("shards") - 250);
                    item = "Shadowmourne";
                    break;
                }
            }

            if (materials.containsKey("fragments")) {
                if (materials.get("fragments") >= 250) {
                    materials.put("fragments", materials.get("fragments") - 250);
                    item = "Valanyr";
                    break;
                }
            }

            if (materials.containsKey("motes")) {
                if (materials.get("motes") >= 250) {
                    materials.put("motes", materials.get("motes") - 250);
                    item = "Dragonwrath";
                    break;
                }
            }
        }

        System.out.println(item + " obtained!");

        materials.forEach((material, quantity) -> System.out.printf("%s: %d%n", material, quantity));
    }
}
