package _10_FunctionalProgramming_Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> consumer = System.out::println;
        for (int i = 0; i < input.length; i++) {
            consumer.accept(input[i]);
        }
    }
}
