package _07_Methods_Lab;

import java.util.Scanner;

public class MultiplyEvenByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        input = Math.abs(input);

        int result = multiplyEvenByOdds(input);
        System.out.println(result);

    }

    private static int multiplyEvenByOdds(int input) {
        String inStr = input + "";
        int[] in = new int[inStr.length()];
        int odd = 0;
        int even = 0;

        for (int i = in.length - 1; i >= 0; i--) {
            in[i] = input % 10;
            input /= 10;
        }

        for (int i = 0; i < in.length; i++) {
            if (in[i] % 2 == 0) {
                odd += in[i];
            } else {
                even += in[i];
            }
        }

        int result = even * odd;
        return result;
//        int oddSum = 0;
//        int evenSum = 0;
//
//        while (input > )
    }

}
