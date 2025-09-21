package _09_FunctionalProgramming_Lab;

import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        Function<String[], Integer> sum = (strings) -> {
            int sums = 0;
            for (int i = 0; i < strings.length; i++) {
                sums += Integer.parseInt(strings[i]);
            }
            return sums;
        };

        Function<String[], Integer> count = (strings) -> {
            int counts = 0;
            for (int i = 0; i < strings.length; i++) {
                counts++;
            }
            return counts;
        };


        System.out.println("Count = " + count.apply(input));
        System.out.println("Sum = " + sum.apply(input));
    }
}
