package _05_Arrays_Lab;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] array =input.split(" ");
        for (int n =0 ; n< array.length/2; n++){
            String mid = array[n];
            array[n] = array[array.length-1-n];
            array[array.length-1-n] = mid;
        }
        for (int n = 0; n< array.length; n++){
            System.out.print(array[n] + " ");
        }
    }
}
