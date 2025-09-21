package _04_MultidimensionalArrays_Exercises;

import java.util.Scanner;

public class FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int[][] matrix = new int[Integer.parseInt(input[0])][Integer.parseInt(input[0])];

        switch (input[1]) {
            case "A":
                int count = 1;
                for (int i = 0; i < Integer.parseInt(input[0]); i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][i] = count;
                        count++;
                    }
                }
                break;

            case "B":
                int counter = 1;
                for (int i = 0; i < Integer.parseInt(input[0]); i++) {
                    if (i % 2 == 0) {
                        for (int j = 0; j < matrix.length; j++) {
                            matrix[j][i] = counter;
                            counter++;
                        }
                    } else {
                        for (int j = matrix.length - 1; j >= 0; j--) {
                            matrix[j][i] = counter;
                            counter++;
                        }
                    }
                }
                break;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
