package _15_TextProcessing_Lab;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }

            String reverse = "";
            for (int i = input.length()-1; i >= 0; i--) {
                reverse += input.charAt(i);
            }

            System.out.printf("%s = %s%n", input, reverse);
        }
    }
}
