package _03_MultidimensionalArrays_LAB;

import java.util.Scanner;

public class SumMatrixElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(", ");
        int[][] matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(", ");
            int[] rowArray = new int[Integer.parseInt(size[1])];

            for (int j = 0; j < row.length; j++) {
                rowArray[j] = Integer.parseInt(row[j]);
                sum += rowArray[j];
            }
            matrix[i] = rowArray;
        }

        System.out.println(size[0]);
        System.out.println(size[1]);
        System.out.println(sum);
    }
}
