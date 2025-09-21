package _09_FunctionalProgramming_Lab;

import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = scanner.nextInt();
        int upperBound = scanner.nextInt();
        String command = scanner.next().toLowerCase();

        Predicate<Integer> predicate;
        if (command.equals("even")) {
            predicate = n -> n % 2 == 0;
        } else if (command.equals("odd")) {
            predicate = n -> n % 2 != 0;
        } else {
            return;
        }

        filterAndPrintNumbers(lowerBound, upperBound, predicate);
    }

    public static void filterAndPrintNumbers(int lowerBound, int upperBound, Predicate<Integer> predicate) {
        for (int i = lowerBound; i <= upperBound; i++) {
            if (predicate.test(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}