package _03_MultidimensionalArrays_LAB;

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(", ");
        int[][] matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];


        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(", ");
            int[] rowArray = new int[Integer.parseInt(size[1])];

            for (int j = 0; j < row.length; j++) {
                rowArray[j] = Integer.parseInt(row[j]);
            }
            matrix[i] = rowArray;
        }

        int biggestSum = 0;
        int[][] biggestSubmatrix = new int[2][2];
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (sum > biggestSum) {
                    biggestSum = sum;
                    biggestSubmatrix[0][0]=matrix[i][j];
                    biggestSubmatrix[0][1]=matrix[i][j+1];
                    biggestSubmatrix[1][0]=matrix[i+1][j];
                    biggestSubmatrix[1][1]=matrix[i+1][j+1];
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < biggestSubmatrix.length; i++) {
            for (int j = 0; j < biggestSubmatrix[i].length; j++) {
                sum += biggestSubmatrix[i][j];
                System.out.print(biggestSubmatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(sum);
    }
}
