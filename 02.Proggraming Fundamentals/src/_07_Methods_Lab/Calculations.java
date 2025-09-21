package _07_Methods_Lab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String function = scanner.nextLine();
        int fist = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        int result = getCalculation(function, fist, second);
        System.out.println(result);
    }

    private static int getCalculation(String function, int fist, int second) {
        switch (function){
            case "add":
                return fist + second;
            case "multiply":
                return fist*second;
            case "subtract":
                return fist-second;
            case "divide":
                return fist/second;
        }
        return fist;
    }
}
