package _15_ExceptionsAndErrorHandling.P03_EnterNumbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder numbers = new StringBuilder();
        int counter = 0;
        int lastNumber = 1;

        while (counter < 10) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);

                if (number > lastNumber && number <= 100) {
                    if (counter == 0) {
                        numbers.append(number);
                    } else {
                        numbers.append(", ").append(number);
                    }
                    lastNumber = number;
                    counter++;
                } else {
                    System.out.println("Your number is not in range " + lastNumber + " - 100!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            }
        }
        System.out.println(numbers);
    }
}