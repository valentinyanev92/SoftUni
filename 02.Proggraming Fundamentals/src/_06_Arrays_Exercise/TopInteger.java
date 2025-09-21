package _06_Arrays_Exercise;

import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        int[] array = new int[inputArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(inputArray[i]);
        }

        int sequence = 0;
        int maxSequence = 0;
        int index = 0;
        for (int n = 0; n < array.length - 1; n++) {
            if (array[n] == array[n + 1]) {
                sequence++;
                if (sequence > maxSequence) {
                    maxSequence = sequence;
                    index = n+1 - maxSequence;
                    if (array[n] != array[index]) {
                        sequence = 0;
                    }
                }
            } else {
                sequence = 0;
            }
        }
        for (int i = index; i <= index + maxSequence; i++) {
            System.out.print(array[i] + " ");
        }
    }
}