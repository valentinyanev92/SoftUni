package _03_MultidimensionalArrays_LAB;

import java.util.Scanner;

public class FindTheRealQueen_EXTRA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chessboard = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                chessboard[i][j] = line[j].charAt(0);
            }
        }

        CheckForValidQueen(chessboard);
    }

    private static void CheckForValidQueen(char[][] chessboard) {

        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                if (chessboard[i][j] == 'q') {

                    boolean lineLeft = checkLineLeft(chessboard, i, j);
                    boolean lineRight = checkLineRight(chessboard, i, j);
                    boolean lineUp = checkLineUp(chessboard, i, j);
                    boolean lineDown = checkLineDown(chessboard, i, j);
                    boolean checkDiagonals = checkDiagonals(chessboard, i, j);

                    if (lineLeft && lineRight && lineUp && lineDown && checkDiagonals) {
                        System.out.println(i + " " + j);
                    }

                }
            }
        }
    }


    private static boolean checkLineLeft(char[][] chessboard, int row, int col) {

        boolean isValid = false;
        for (int i = 0; i < col; i++) {
            if (chessboard[row][i] != 'q') {
                isValid = true;
            } else {
                return false;
            }
        }

        return isValid;
    }

    private static boolean checkLineRight(char[][] chessboard, int row, int col) {

        boolean isValid = false;
        for (int i = col + 1; i < chessboard[row].length; i++) {
            if (chessboard[row][i] != 'q') {
                isValid = true;
            } else {
                return false;
            }
        }

        return isValid;
    }

    private static boolean checkLineUp(char[][] chessboard, int row, int col) {

        boolean isValid = false;
        for (int i = 0; i < row - 1; i++) {
            if (chessboard[i][col] != 'q') {
                isValid = true;
            } else {
                return false;
            }
        }

        return isValid;
    }

    private static boolean checkLineDown(char[][] chessboard, int row, int col) {

        boolean isValid = false;
        for (int i = row + 1; i < 8; i++) {
            if (chessboard[i][col] != 'q') {
                isValid = true;
            } else {
                return false;
            }
        }

        return isValid;
    }

    private static boolean checkDiagonals(char[][] chessboard, int row, int col) {

        boolean upLeft = upLeftDiagonalCheck(chessboard, row, col);
        boolean upRight = upRightDiagonalCheck(chessboard, row, col);
        boolean downLeft = downLeftDiagonalCheck(chessboard, row, col);
        boolean downRight = downRightDiagonalCheck(chessboard, row, col);

        return upLeft && upRight && downLeft && downRight;
    }

    private static boolean upLeftDiagonalCheck(char[][] chessboard, int row, int col) {

        boolean isValid = false;
        int rowCheck = 0;
        for (int i = row - 1; i >= 0; i--) {
            rowCheck++;
            for (int j = col - rowCheck; j >= 0; j--) {
                if (j == col - rowCheck) {

                    if (chessboard[i][j] != 'q') {
                        isValid = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return isValid;
    }

    private static boolean upRightDiagonalCheck(char[][] chessboard, int row, int col) {

        boolean isValid = false;
        int rowCheck = 0;
        for (int i = row - 1; i >= 0; i--) {
            rowCheck++;
            for (int j = col + rowCheck; j <= chessboard[i].length - 1; j++) {
                if (j == col + rowCheck) {

                    if (chessboard[i][j] != 'q') {
                        isValid = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return isValid;
    }

    private static boolean downLeftDiagonalCheck(char[][] chessboard, int row, int col) {

        boolean isValid = false;
        int rowCheck = 0;
        for (int i = row + 1; i < chessboard.length; i++) {
            rowCheck++;
            for (int j = col - rowCheck; j >= 0; j--) {
                if (j == col - rowCheck) {

                    if (chessboard[i][j] != 'q') {
                        isValid = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return isValid;
    }

    private static boolean downRightDiagonalCheck(char[][] chessboard, int row, int col) {

        boolean isValid = false;
        int rowCheck = 0;
        for (int i = row + 1; i < chessboard.length; i++) {
            rowCheck++;
            for (int j = col + rowCheck; j <= chessboard[i].length - 1; j++) {
                if (j == col + rowCheck) {

                    if (chessboard[i][j] != 'q') {
                        isValid = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return isValid;
    }


}
