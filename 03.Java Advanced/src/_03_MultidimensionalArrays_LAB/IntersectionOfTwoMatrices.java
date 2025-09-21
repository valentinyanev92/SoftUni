package _03_MultidimensionalArrays_LAB;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cows = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cows];
        char[][] secondMatrix = new char[rows][cows];

        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                firstMatrix[i][j] = line[j].charAt(0);
            }
        }

        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                secondMatrix[i][j] = line[j].charAt(0);
            }
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    System.out.print(firstMatrix[i][j] + " ");
                } else {
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }


    }
}
