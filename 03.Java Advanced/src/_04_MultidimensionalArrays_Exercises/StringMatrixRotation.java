package _04_MultidimensionalArrays_Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotationInput = scanner.nextLine();
        int rotationDegrees = Integer.parseInt(rotationInput.replaceAll("[^0-9]", "")) % 360;

        List<String> lines = new ArrayList<>();
        int maxCols = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("END")) break;
            lines.add(line);
            maxCols = Math.max(maxCols, line.length());  // Keep track of the max width
        }

        int rows = lines.size();
        char[][] matrix = new char[rows][maxCols];

        for (int i = 0; i < rows; i++) {
            String line = lines.get(i);
            for (int j = 0; j < maxCols; j++) {
                matrix[i][j] = (j < line.length()) ? line.charAt(j) : ' ';
            }
        }

        switch (rotationDegrees) {
            case 90:
                printMatrix(rotate90(matrix, rows, maxCols));
                break;
            case 180:
                printMatrix(rotate180(matrix, rows, maxCols));
                break;
            case 270:
                printMatrix(rotate270(matrix, rows, maxCols));
                break;
            default:
                printMatrix(matrix);
                break;
        }
    }

    private static char[][] rotate90(char[][] matrix, int rows, int cols) {
        char[][] rotated = new char[cols][rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rotated[c][rows - 1 - r] = matrix[r][c];
            }
        }
        return rotated;
    }

    private static char[][] rotate180(char[][] matrix, int rows, int cols) {
        char[][] rotated = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rotated[rows - 1 - r][cols - 1 - c] = matrix[r][c];
            }
        }
        return rotated;
    }

    private static char[][] rotate270(char[][] matrix, int rows, int cols) {
        char[][] rotated = new char[cols][rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rotated[cols - 1 - c][r] = matrix[r][c];
            }
        }
        return rotated;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(new String(row));
        }
    }
}

