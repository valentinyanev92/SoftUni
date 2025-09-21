package _03_MultidimensionalArrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();

        int[][] matricesF = new int[dimensions[0]][];
        for (int i = 0; i < dimensions[0]; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
            matricesF[i] = array;
        }

        dimensions = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int[][] matricesS = new int[dimensions[0]][];
        for (int i = 0; i < dimensions[0]; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
            matricesS[i] = array;
        }

        boolean isEqual = compare(matricesF, matricesS);
        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }


    private static boolean compare(int[][] matricesF, int[][] matricesS) {

        if (matricesF.length != matricesS.length) {
            return false;
        }

        for (int r = 0; r < matricesF.length; r++) {

            if (matricesF[r].length != matricesS[r].length) {
                return false;
            }

            for (int c = 0; c < matricesF[r].length; c++) {
                if (matricesF[r][c] != matricesS[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }
}
