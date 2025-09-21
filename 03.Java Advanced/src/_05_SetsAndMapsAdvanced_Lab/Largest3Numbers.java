package _05_SetsAndMapsAdvanced_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Largest3Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        List<Integer> sorted = numbers.stream().sorted((n1, n2) -> n2.compareTo(n1)).toList();

        if (sorted.size() <= 2) {
            sorted.forEach(n -> System.out.print(n + " "));
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(sorted.get(i) + " ");
            }
        }
    }
}
