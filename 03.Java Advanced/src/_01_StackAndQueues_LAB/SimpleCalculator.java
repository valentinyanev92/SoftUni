package _01_StackAndQueues_LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> calculator = new ArrayDeque<>();
        String[] input = scanner.nextLine().split(" ");
        calculator.add(Integer.parseInt(input[0]));
        String operation = "";
        for (int i = 1; i < input.length; i++) {

            if (i % 2 == 1) {
                operation = input[i];
            }

            if (i % 2 == 0) {
                switch (operation) {
                    case "+": {
                        int sum = calculator.pop() + Integer.parseInt(input[i]);
                        calculator.add(sum);
                        break;
                    }
                    case "-": {
                        int sum = calculator.pop() - Integer.parseInt(input[i]);
                        calculator.add(sum);
                        break;
                    }
                }
            }

        }

        System.out.println(calculator.peek());
    }
}