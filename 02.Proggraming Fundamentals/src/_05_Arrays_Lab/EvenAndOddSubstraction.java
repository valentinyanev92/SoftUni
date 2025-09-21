package _05_Arrays_Lab;

import java.util.Scanner;

public class EvenAndOddSubstraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputString = input.split(" ");
        int[] inputInt = new int[inputString.length];
        for (int i = 0; i < inputString.length; i++) {
            inputInt[i] = Integer.parseInt(inputString[i]);
        }
        int odd = 0;
        int even = 0;
        for (int i = 0; i < inputInt.length; i++) {
            if (inputInt[i] % 2 == 0) {
                even += inputInt[i];
            } else {
                odd += inputInt[i];
            }
        }
        int diference = even - odd;
        System.out.println(diference);
    }
}
