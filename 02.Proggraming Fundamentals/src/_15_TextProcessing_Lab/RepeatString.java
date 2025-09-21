package _15_TextProcessing_Lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]  input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            int size = input[i].length();
            for (int j = 0; j < size; j++) {
                System.out.print(input[i]);
            }
        }
    }
}
