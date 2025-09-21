package _15_TextProcessing_Lab;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String digits = "";
        String letters = "";
        String other = "";

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            boolean digitCheck = Character.isDigit(current);
            boolean letterCheck = Character.isLetter(current);

            if (digitCheck){
                digits += current;
            }else if (letterCheck){
                letters += current;
            }else {
                other += current;
            }
        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(other);
    }
}
