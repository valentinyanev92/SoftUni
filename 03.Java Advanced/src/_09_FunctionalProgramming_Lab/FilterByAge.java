package _09_FunctionalProgramming_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            map.put(name, age);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String conditions = scanner.nextLine();

        boolean isYounger = isYounger(condition);

            switch (conditions){
                case "name" -> printName(map, isYounger, age);
                case "age" -> printAge(map, isYounger, age);
                case "name age" -> printNameAge(map, isYounger, age);
        }
    }

    private static void printNameAge(Map<String, Integer> map, boolean isYounger, int age) {

        map.forEach((k, v) -> {
            if (isYounger) {
                if (v <= age) {
                    System.out.println(k + " - " + v);
                }
            }else {
                if (v >= age) {
                    System.out.println(k + " - " + v);
                }
            }
        });

    }

    private static void printAge(Map<String, Integer> map, boolean isYounger, int age) {

        map.forEach((k, v) -> {
            if (isYounger) {
                if (v <= age) {
                    System.out.println(v);
                }
            }else {
                if (v >= age) {
                    System.out.println(v);
                }
            }
        });
    }

    private static void printName(Map<String, Integer> map, boolean isYounger, int age) {

        map.forEach( (k,v) -> {
            if (isYounger) {
                if (v <= age) {
                    System.out.println(k);
                }
            }else {
                if (v >= age) {
                    System.out.println(k);
                }
            }
        });
    }


    private static boolean isYounger(String condition) {
        if (condition.equals("younger")) {
            return true;
        }
        return false;
    }
}
