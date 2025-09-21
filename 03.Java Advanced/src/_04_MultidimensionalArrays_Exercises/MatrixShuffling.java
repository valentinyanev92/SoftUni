package _04_MultidimensionalArrays_Exercises;

import java.util.Scanner;

public class MatrixShuffling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        String[][] matrix = new String[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];

        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input[j];
            }
        }

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("END")) {
                break;
            }

            switch (input[0]){
                case "swap" : {
                    if (swapCheck(matrix, input)) {

                        matrix = swapMatrix(matrix, input);

                        printMatrix(matrix);

                    }else {
                        System.out.println("Invalid input!");
                    }
                    break;
                }
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] swapMatrix(String[][] matrix, String[] input) {

        int rowFirst = Integer.parseInt(input[1]);
        int colFirst = Integer.parseInt(input[2]);
        int rowLast = Integer.parseInt(input[3]);
        int colLast = Integer.parseInt(input[4]);

        String temp = matrix[rowFirst][colFirst];
        matrix[rowFirst][colFirst] = matrix[rowLast][colLast];
        matrix[rowLast][colLast] = temp;

        return matrix;
    }

    private static boolean swapCheck(String[][] matrix, String[] input) {
        boolean result = false;
        if (input.length == 5) {
            result = true;
        }else {
            return false;
        }

        int rowFirst = Integer.parseInt(input[1]);
        int colFirst = Integer.parseInt(input[2]);
        int rowLast = Integer.parseInt(input[3]);
        int colLast = Integer.parseInt(input[4]);

        if (rowFirst < matrix.length && colFirst < matrix[rowFirst].length
        && rowLast < matrix.length && colLast < matrix[rowLast].length) {
            result = true;
        } else {
            return false;
        }

        return result;
    }
}
