package _04_MultidimensionalArrays_Exercises;

import java.util.Scanner;

public class MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String[][] matrix = new String[Integer.parseInt(input[0])][Integer.parseInt(input[1])];

        matrix = fillMatrix(matrix);

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] fillMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = getLetters(i, j);
            }
        }

        return matrix;
    }

    private static String getLetters(int i, int j) {
        String letters = "";

        switch (i){
            case 0 -> letters += "a";
            case 1 -> letters += "b";
            case 2 -> letters += "c";
            case 3 -> letters += "d";
            case 4 -> letters += "e";
            case 5 -> letters += "f";
            case 6 -> letters += "g";
            case 7 -> letters += "h";
            case 8 -> letters += "i";
            case 9 -> letters += "j";
            case 10 -> letters += "k";
            case 11 -> letters += "l";
            case 12 -> letters += "m";
            case 13 -> letters += "n";
            case 14 -> letters += "o";
            case 15 -> letters += "p";
            case 16 -> letters += "q";
            case 17 -> letters += "r";
            case 18 -> letters += "s";
            case 19 -> letters += "t";
            case 20 -> letters += "u";
            case 21 -> letters += "v";
            case 22 -> letters += "w";
            case 23 -> letters += "x";
            case 24 -> letters += "y";
            case 25 -> letters += "z";
        }

        switch (i+j){
            case 0 -> letters += "a";
            case 1 -> letters += "b";
            case 2 -> letters += "c";
            case 3 -> letters += "d";
            case 4 -> letters += "e";
            case 5 -> letters += "f";
            case 6 -> letters += "g";
            case 7 -> letters += "h";
            case 8 -> letters += "i";
            case 9 -> letters += "j";
            case 10 -> letters += "k";
            case 11 -> letters += "l";
            case 12 -> letters += "m";
            case 13 -> letters += "n";
            case 14 -> letters += "o";
            case 15 -> letters += "p";
            case 16 -> letters += "q";
            case 17 -> letters += "r";
            case 18 -> letters += "s";
            case 19 -> letters += "t";
            case 20 -> letters += "u";
            case 21 -> letters += "v";
            case 22 -> letters += "w";
            case 23 -> letters += "x";
            case 24 -> letters += "y";
            case 25 -> letters += "z";
        }

        letters += letters.charAt(0);

        return letters;
    }
}
