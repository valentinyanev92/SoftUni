package _15_ExceptionsAndErrorHandling.P02_SquareRoot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            int x = Integer.parseInt(input);
            double y = Math.sqrt(x);
            if (x <= 0) {
                throw new Exception();
            }
            System.out.printf("%.2f%n", y);

        } catch (Exception e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
