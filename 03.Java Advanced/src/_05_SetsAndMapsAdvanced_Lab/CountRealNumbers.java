package _05_SetsAndMapsAdvanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> values = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (!values.containsKey(numbers[i])) {
                values.put(numbers[i], 1);
            } else {
                values.put(numbers[i], values.get(numbers[i]) + 1);
            }
        }

        values.entrySet().forEach(entry ->
        System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue()));
    }
}
