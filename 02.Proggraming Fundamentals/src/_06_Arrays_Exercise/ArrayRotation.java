package _06_Arrays_Exercise;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arrayString = input.split(" ");
        int[] array = new int[arrayString.length];
        for (int n = 0; n < array.length; n++) {
            array[n] = Integer.parseInt(arrayString[n]);
        }
        int rotation = Integer.parseInt(scanner.nextLine());
        for (int n = 0; n < rotation; n++) {
            for (int i = 0; i < array.length; i++) {
                int arrayTemp = array[i];
                for (int j = 0; j < array.length - 1; j++) {

                    array[j] = array[j + 1];
                }
                array[array.length - 1] = arrayTemp;
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}


