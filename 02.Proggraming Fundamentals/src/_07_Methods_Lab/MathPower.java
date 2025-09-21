package _07_Methods_Lab;

import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double first = Double.parseDouble(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        double result = mathPow(first, second);
        System.out.printf("%.0f",result);
    }

    private static double mathPow(double first, int pow) {
//        double result = first;
//        for (int n=1; n<pow;n++){
//            result *= first;
//        }
//        return result;
        return Math.pow(first,pow);

    }
}
