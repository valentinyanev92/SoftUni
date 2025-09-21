package _10_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AppliedArithmetics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        String operation = scanner.nextLine();

        Function<Integer[], Integer[]> add = ((x)-> {
            Integer[] newNumbers = new Integer[x.length];
            for (int i = 0; i < x.length; i++) {
                newNumbers[i] = x[i]+1;
            }
            return newNumbers;
        });

        Function<Integer[], Integer[]> multiply = ((x)-> {
            Integer[] newNumbers = new Integer[x.length];
            for (int i = 0; i < x.length; i++) {
                newNumbers[i] = x[i]*2;
            }
            return newNumbers;
        });

        Function<Integer[], Integer[]> subtract = ((x)-> {
            Integer[] newNumbers = new Integer[x.length];
            for (int i = 0; i < x.length; i++) {
                newNumbers[i] = x[i] -1;
            }
            return newNumbers;
        });

        Function<Integer[], Integer> print = ( x -> {
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
            return null;
        });

        while (!operation.equals("end")) {

            switch (operation) {
                case "add" -> numbers = add.apply(numbers);
                case "subtract" -> numbers = subtract.apply(numbers);
                case "multiply" -> numbers = multiply.apply(numbers);
                case "print" -> print.apply(numbers);
            }

            operation = scanner.nextLine();
        }
    }
}
