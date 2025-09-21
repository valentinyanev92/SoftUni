package _02_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String numberString = String.valueOf(number);
        int sum = 0;
        for (int i = 0; i < numberString.length(); i++) {
            int current = Integer.parseInt(String.valueOf(numberString.charAt(i)));
            int midSum = 1;
            for (int j = 1; j <= current ; j++) {
                midSum *= j;
            }
            sum += midSum;
        }

        if (sum==number){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
