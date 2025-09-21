package _04_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            int current = Integer.parseInt(String.valueOf(input.charAt(i)));
            result += current;
        }
        System.out.println(result);
    }
}
