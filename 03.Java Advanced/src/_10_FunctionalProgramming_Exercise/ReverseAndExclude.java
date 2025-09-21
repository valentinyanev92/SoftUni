package _10_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Function<Integer[], Integer[]> reverse = (in) -> {
            Integer[] reversed = new Integer[in.length];
            for (int i = 0; i < reversed.length; i++) {
                reversed[i] = in[in.length - 1 - i];
            }
            return reversed;
        };
        Integer[] reversed = reverse.apply(numbers);

        int divisor = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < reversed.length; i++) {
            if (reversed[i] % divisor != 0) {
                System.out.print(reversed[i] + " ");
            }
        }
    }
}
