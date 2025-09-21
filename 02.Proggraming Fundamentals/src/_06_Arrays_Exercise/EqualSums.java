package _06_Arrays_Exercise;

import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputAsArray = input.split(" ");
        int[] array = new int[inputAsArray.length];
        for (int n = 0; n < array.length; n++) {
            array[n] = Integer.parseInt(inputAsArray[n]);
        }
        int leftSum = 0;
        int rightSum = 0;
        int equalSum = 0;
        boolean equalCheck = false;

        for (int n = 0; n < array.length; n++) {
            for (int l = 0; l < n; l++) {
                leftSum += array[l];
            }
            for (int r = n + 1; r < array.length; r++) {
                rightSum += array[r];
            }
            if (leftSum == rightSum) {
                equalSum = n;
                equalCheck = true;
            }
            leftSum = 0;
            rightSum = 0;
        }
        if (equalCheck==true){
            System.out.println(equalSum);
        }else {
            System.out.println("no");
        }
    }
}
