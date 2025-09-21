package _09_FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new java.util.ArrayList<>(Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).toList());

        numbers.removeIf(n -> n % 2 != 0);
        for (int i = 0; i < numbers.size(); i++) {
            if (i != numbers.size() - 1) {
                System.out.print(numbers.get(i) + ", ");
            } else {
                System.out.println(numbers.get(i));
            }
        }


        numbers.sort(Integer::compareTo);
        for (int i = 0; i < numbers.size(); i++) {
            if (i != numbers.size() - 1) {
                System.out.print(numbers.get(i) + ", ");
            } else {
                System.out.println(numbers.get(i));
            }
        }
    }
}
