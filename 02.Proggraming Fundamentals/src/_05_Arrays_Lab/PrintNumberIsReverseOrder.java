package _05_Arrays_Lab;

import java.util.Scanner;

public class PrintNumberIsReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] list = new int[length];
        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            list[i] = number;
        }
        for (int n = length-1; n >= 0; n--) {
            System.out.print(list[n]+" ");
        }
    }
}
