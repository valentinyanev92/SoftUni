package _04_MultidimensionalArrays_Exercises;

import java.util.Scanner;

public class MaximalSum {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] dimensions = scanner.nextLine().split(" ");
        int[][] matrix = new int[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];

        fillMatrix(matrix);

        int[] bestArray = findBestSum(matrix);
        int[][] bestMatrix = new int[3][3];
        bestMatrix = getBestMatrix(matrix, bestArray[1], bestArray[2]);

        System.out.println("Sum = " + bestArray[0]);
        for (int i = 0; i < bestMatrix.length; i++) {
            for (int j = 0; j < bestMatrix[i].length; j++) {
                System.out.print(bestMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] getBestMatrix(int[][] matrix, int row, int cow) {
        int[][] bestMatrix = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bestMatrix[i][j] = matrix[row + i][cow + j];
            }
        }

        return bestMatrix;
    }


    private static int[] findBestSum(int[][] matrix) {

        int bestSum = 0;

        int row = 0;
        int cow = 0;


        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int currentSum = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        currentSum += matrix[k][l];
                    }
                }

                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    row = i;
                    cow = j;
                }

            }
        }

        int[] best = new int[3];
        best[0] = bestSum;
        best[1] = row;
        best[2] = cow;

        return best;
    }

    private static void fillMatrix(int[][] matrix) {

            for (int j = 0; j < matrix.length; j++) {
                String[] input = scanner.nextLine().split(" ");
                for (int k = 0; k < matrix[j].length; k++) {
                    matrix[j][k] = Integer.parseInt(input[k]);
                }
            }
    }

}

