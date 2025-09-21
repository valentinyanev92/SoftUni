package _08_Methods_Exercise;

import java.util.Scanner;

public class CharInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String begin = scanner.nextLine();
        String end = scanner.nextLine();

        printCharInRange(begin, end);
    }

    private static void printCharInRange(String  begin, String end) {
        int beginChar = (int) begin.charAt(0);
        int endChar = (int) end.charAt(0);
        for (int i = beginChar + 1 ; i < endChar; i++){
            char in =  (char) i;
            System.out.print(in+" ");
        }
    }
}
