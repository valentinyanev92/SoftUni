package _04_MultidimensionalArrays_Exercises;

import java.util.Scanner;

public class DiagonalDifference {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int dimensions = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimensions][dimensions];

        fillMatrix(matrix);

        int primaryDiagonalSum = getPrimariDiagonalSum(matrix);
        int secondaryDiagonalSum = getSecondaryDiagonalSum(matrix);

        int difference = primaryDiagonalSum - secondaryDiagonalSum;
        if (difference < 0) {
            difference = -difference;
        }
        System.out.println(difference);

    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;

        int position = 0;
        for (int i = matrix.length-1; i >= 0; i--) {
            sum += matrix[i][position];
            position++;
        }

        return sum;
    }

    private static int getPrimariDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][i];
        }

        return sum;
    }

    private static void fillMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
}
