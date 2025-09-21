package _06_Arrays_Exercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] arrayOne = new int[length];
        int[] arrayTwo = new int[length];
        for (int n = 0; n < length; n++) {
            if (n % 2 == 0) {
                arrayOne[n] = scanner.nextInt();
                arrayTwo[n] = scanner.nextInt();
            } else {
                arrayTwo[n] = scanner.nextInt();
                arrayOne[n] = scanner.nextInt();
            }
        }
        for (int i = 0; i < arrayOne.length; i++) {
            System.out.print(arrayOne[i] + " ");
            if (i == arrayOne.length - 1) {
                System.out.println();
            }
        }
        for (int i = 0; i < arrayTwo.length; i++) {
            System.out.print(arrayTwo[i] + " ");
            if (i == arrayTwo.length - 1) {
                System.out.println();
            }
        }
    }

}
