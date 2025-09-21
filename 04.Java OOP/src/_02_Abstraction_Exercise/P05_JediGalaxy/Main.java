package _02_Abstraction_Exercise.P05_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] field = new int[x][y];
        fillMatrix(field);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] playerMoves = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            moveEvil(evilCoordinates, field);
            sum += movePlayer(playerMoves, field, sum);
            command = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static long movePlayer(int[] playerMoves, int[][] field, long sum) {
        int x = playerMoves[0];
        int y = playerMoves[1];

        while (x >= 0 && y < field[1].length) {
            if (x >= 0 && x < field.length && y >= 0 && y < field[0].length) {
                sum += field[x][y];
            }
            y++;
            x--;
        }

        return sum;
    }

    private static void moveEvil(int[] evilCoordinates, int[][] field) {
        int x = evilCoordinates[0];
        int y = evilCoordinates[1];

        while (x >= 0 && y >= 0) {
            if (x >= 0 && x < field.length && y >= 0 && y < field[0].length) {
                field[x][y] = 0;
            }
            x--;
            y--;
        }
    }

    public static void fillMatrix(int[][] matrix) {
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
