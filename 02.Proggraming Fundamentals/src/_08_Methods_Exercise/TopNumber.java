package _08_Methods_Exercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            boolean divisible = isDivisibleBy8(i);
            boolean oddDigit = isHaveOddDigit(i);

            if (divisible == true && oddDigit == true) {
                System.out.println(i);
            }
        }
    }

    private static boolean isHaveOddDigit(int number) {

            int num = number;
            int current;
            while (num > 0) {
                current = num % 10;
                num /= 10;
                if (current % 2 == 1) {
                    return true;
                }
            }

        return false;
    }

    private static boolean isDivisibleBy8(int number) {
        int num = number;
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
            if (sum % 8 == 0) {
                return true;
            } else {
                return false;
            }


    }
}
