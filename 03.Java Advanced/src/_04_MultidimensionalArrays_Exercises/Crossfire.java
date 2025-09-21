package _04_MultidimensionalArrays_Exercises;

import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Nuke it from orbit")) break;

            String[] tokens = command.split(" ");
            int targetRow = Integer.parseInt(tokens[0]);
            int targetCol = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            destroyCells(matrix, targetRow, targetCol, radius);
            matrix = cleanMatrix(matrix);
        }
        scanner.close();

        printMatrix(matrix);
    }

    private static void destroyCells(int[][] matrix, int row, int col, int radius) {
        for (int r = Math.max(0, row - radius); r <= Math.min(matrix.length - 1, row + radius); r++) {
            if (col >= 0 && col < matrix[r].length) {
                matrix[r][col] = -1;
            }
        }

        if (row >= 0 && row < matrix.length) {
            for (int c = Math.max(0, col - radius); c <= Math.min(matrix[row].length - 1, col + radius); c++) {
                matrix[row][c] = -1;
            }
        }
    }

    private static int[][] cleanMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = removeNegatives(matrix[i]);
        }

        return removeEmptyRows(matrix);
    }

    private static int[] removeNegatives(int[] row) {
        int count = 0;
        for (int num : row) {
            if (num != -1) count++;
        }

        int[] newRow = new int[count];
        int index = 0;
        for (int num : row) {
            if (num != -1) {
                newRow[index++] = num;
            }
        }

        return newRow;
    }

    private static int[][] removeEmptyRows(int[][] matrix) {
        int validRows = 0;
        for (int[] row : matrix) {
            if (row.length > 0) validRows++;
        }

        int[][] newMatrix = new int[validRows][];
        int index = 0;
        for (int[] row : matrix) {
            if (row.length > 0) {
                newMatrix[index++] = row;
            }
        }

        return newMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            if (row.length > 0) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}