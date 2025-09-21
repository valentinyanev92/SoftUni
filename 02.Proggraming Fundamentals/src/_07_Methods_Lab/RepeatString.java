package _07_Methods_Lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int repeat = Integer.parseInt(scanner.nextLine());
        
        getPrintRepeat(input, repeat);
    }

    private static void getPrintRepeat(String input, int repeat) {
        String[] array = new String[repeat];
        for (int n = 0; n < array.length; n++) {
            array[n]=input;
        }
        for (int n = 0; n < repeat; n++) {
            System.out.print(array[n]);
        }
    }
}
