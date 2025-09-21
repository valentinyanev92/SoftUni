package _06_Arrays_Exercise;

import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputAsArray = input.split(" ");
        int[] array = new int[inputAsArray.length];
        for (int n = 0; n < array.length; n++) {
            array[n] = Integer.parseInt(inputAsArray[n]);
        }
        int magicNumber = Integer.parseInt(scanner.nextLine());
        for (int n = 0; n < array.length; n++) {
            for (int i = n+1; i < array.length; i++) {
                if (array[n] + array[i] == magicNumber) {
                    System.out.printf("%d %d%n", array[n], array[i]);
                }
            }
        }
    }
}
