package _01_Abstractions_Lab.P1_RhombusOfStarts;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        drawRhombus(dimensions);

    }

    private static void drawRhombus(int dimensions) {

        if (dimensions == 1){
            System.out.println("*");
            return;
        }

        for (int row = 0; row <= dimensions; row++) {
            printRow(row, dimensions);
        }

        for (int row = dimensions-1; row >= 1 ; row--) {
            printRow(row, dimensions);
        }
    }

    private static void printRow(int row, int dimensions) {

        int whiteSpace = dimensions - row ;
        for (int i = 0; i < whiteSpace; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < row; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
