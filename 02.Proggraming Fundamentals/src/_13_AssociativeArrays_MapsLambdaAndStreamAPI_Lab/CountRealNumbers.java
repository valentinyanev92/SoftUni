package _13_AssociativeArrays_MapsLambdaAndStreamAPI_Lab;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Map<Double, Integer> counter = new TreeMap<>();

        for (int i = 0; i < input.length; i++) {
            double current = Double.parseDouble(input[i]);
            counter.putIfAbsent(current, 0);
            counter.replace(current, counter.get(current) + 1);
        }

        for (Map.Entry<Double, Integer> entry : counter.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
