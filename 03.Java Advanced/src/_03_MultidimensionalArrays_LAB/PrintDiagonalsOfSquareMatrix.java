package _03_MultidimensionalArrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }


        for (int i = 0; i < size; i++) {
            System.out.print(matrix[0+i][0+i] + " ");
        }
        System.out.println();
        for (int i = size-1; i >=0 ; i--) {
            System.out.print(matrix[0+i][size-i-1] + " ");
        }
    }
}
