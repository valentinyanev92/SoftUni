package _07_Methods_Lab;

import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        positiveOrNegative(number);

    }

    public static void positiveOrNegative(int n){
        if(n < 0){
            System.out.println("The number "+n+" is negative.");
        } else if (n>0) {
            System.out.println("The number "+n+" is positive.");
        }else {
            System.out.println("The number "+n+" is zero.");
        }
    }
}
