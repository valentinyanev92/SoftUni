package _05_Arrays_Lab;

import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String[] firstString = first.split(" ");
        String[] secondString = second.split(" ");
        int[] firstInt = new int[firstString.length];
        int[] secondInt = new int[secondString.length];
        for (int n = 0; n < firstString.length; n++) {
            firstInt[n] = Integer.parseInt(firstString[n]);
        }
        for (int n = 0; n < secondString.length; n++) {
            secondInt[n] = Integer.parseInt(secondString[n]);
        }
        int sum = 0;
        for (int n = 0; n < firstInt.length; n++) {
            sum += firstInt[n];
            if (firstInt[n] != secondInt[n]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", n);
                return;
            }
        }
        System.out.println("Arrays are identical. Sum: " + sum);
    }
}
