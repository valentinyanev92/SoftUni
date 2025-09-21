package _08_Methods_Exercise;

import java.util.Scanner;

public class MiddleChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String mid = getMiddleString(input);
        System.out.println(mid);
    }

    private static String getMiddleString(String input) {
        int length = input.length();
        String mid = "";
        if (length%2==0){
            mid += input.charAt(length/2-1);
            mid += input.charAt(length/2);
        }else {
            mid += input.charAt(length/2);
        }
        return mid;
    }
}
