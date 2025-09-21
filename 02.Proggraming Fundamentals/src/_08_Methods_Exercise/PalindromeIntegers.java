package _08_Methods_Exercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true){
        input = scanner.nextLine();
        if (input.equals("END")){
            break;
        }
        boolean isValid = isPalindrome(input);
            System.out.println(isValid);
        }
    }

    private static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length()/2; i++) {
            if (input.charAt(i) != input.charAt(input.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
