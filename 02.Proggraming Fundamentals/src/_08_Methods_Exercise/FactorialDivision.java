package _08_Methods_Exercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        double second = Double.parseDouble(scanner.nextLine());

        double result = getFactorial(first);
        result = division(result, second);

        System.out.printf("%.2f", result);
    }

    private static double division(double first, double second) {
        double number = first / second;
        return number;
    }

    private static int getFactorial(int first) {
        int number = 1;

        for (int i = first; i > 0; i--) {
            number *= i;
        }

        return number;
    }
}
