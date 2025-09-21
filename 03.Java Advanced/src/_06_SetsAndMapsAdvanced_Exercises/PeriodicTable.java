package _06_SetsAndMapsAdvanced_Exercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                elements.add(input[j]);
            }
        }

        elements.forEach( value -> System.out.print(value + " "));
    }
}
