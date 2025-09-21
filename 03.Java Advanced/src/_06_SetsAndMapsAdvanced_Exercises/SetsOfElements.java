package _06_SetsAndMapsAdvanced_Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lengths = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(lengths[0]);
        int m = Integer.parseInt(lengths[1]);

        Set<Integer> nSet = new LinkedHashSet<>();
        Set<Integer> mSet = new LinkedHashSet<>();

        Set<Integer> duplicates = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            int currentElement = Integer.parseInt(scanner.nextLine());
            nSet.add(currentElement);
        }

        for (int i = 0; i < m; i++) {
            int currentElement = Integer.parseInt(scanner.nextLine());
            mSet.add(currentElement);
        }

        nSet.forEach( value -> {
            if (mSet.contains(value)) {
                duplicates.add(value);
            }
        });

        duplicates.forEach( value -> {
            System.out.print(value + " ");
        });
    }
}
