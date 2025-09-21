package _10_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Function<Integer[], Integer> min = ((array) -> {
            int minimum = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < minimum) {
                    minimum = array[i];
                }
            }
            return minimum;
        });

        int minimum = min.apply(numbers);
        System.out.println(minimum);
    }
}
