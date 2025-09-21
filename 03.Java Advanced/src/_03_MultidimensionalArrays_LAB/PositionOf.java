package _03_MultidimensionalArrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();

        int[][] matrice = new int[dimensions[0]][];
        for (int i = 0; i < dimensions[0]; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
            matrice[i] = array;
        }

        int search = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == search) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }

    }
}
