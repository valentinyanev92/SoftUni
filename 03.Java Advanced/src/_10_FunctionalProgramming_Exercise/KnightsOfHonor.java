package _10_FunctionalProgramming_Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> consumer = s-> System.out.println("Sir " + s);
        for (int i = 0; i < input.length; i++) {
            consumer.accept(input[i]);
        }
    }
}
