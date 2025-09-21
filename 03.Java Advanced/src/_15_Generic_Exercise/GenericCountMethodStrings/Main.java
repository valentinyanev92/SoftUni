package _15_Generic_Exercise.GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            boxes.add(new Box<>(input));
        }

        String comparisonValue = scanner.nextLine();
        int result = countGreaterThan(boxes.stream().map(Box::getValue).toList(), comparisonValue);
        System.out.println(result);
    }

    public static <T extends Comparable<T>> int countGreaterThan(List<T> list, T element) {
        int count = 0;
        for (T item : list) {
            if (item.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

}
