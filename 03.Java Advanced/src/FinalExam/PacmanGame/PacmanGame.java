package FinalExam.PacmanGame;

import java.util.*;

public class PacmanGame {
    static int N;
    static char[][] grid;
    static int pacmanRow;
    static int pacmanCol;
    static int health = 100;
    static int starsCount = 0;
    static boolean hasFreeze = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'P') {
                    pacmanRow = i;
                    pacmanCol = j;
                } else if (grid[i][j] == '*') {
                    starsCount++;
                }
            }
        }

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("END")) {
                break;
            }
            movePacman(command);
            if (health <= 0 || starsCount == 0) {
                break;
            }
        }

        printResult();
    }

    private static void movePacman(String direction) {
        int newRow = pacmanRow;
        int newCol = pacmanCol;

        switch (direction) {
            case "up":
                newRow = (pacmanRow - 1 + N) % N;
                break;
            case "down":
                newRow = (pacmanRow + 1) % N;
                break;
            case "left":
                newCol = (pacmanCol - 1 + N) % N;
                break;
            case "right":
                newCol = (pacmanCol + 1) % N;
                break;
        }

        grid[pacmanRow][pacmanCol] = '-';
        char newPosition = grid[newRow][newCol];

        if (newPosition == '*') {
            starsCount--;
        } else if (newPosition == 'G') {
            if (hasFreeze) {
                hasFreeze = false;
            } else {
                health -= 50;
                if (health <= 0) {
                    pacmanRow = newRow;
                    pacmanCol = newCol;
                    grid[pacmanRow][pacmanCol] = 'P';
                    return;
                }
            }
        } else if (newPosition == 'F') {
            hasFreeze = true;
        }

        pacmanRow = newRow;
        pacmanCol = newCol;
        grid[pacmanRow][pacmanCol] = 'P';
    }

    private static void printResult() {
        if (health <= 0) {
            System.out.println("Game over! Pacman last coordinates [" + pacmanRow + "," + pacmanCol + "]");
        } else if (starsCount == 0) {
            System.out.println("Pacman wins! All the stars are collected.");
        } else {
            System.out.println("Pacman failed to collect all the stars.");
        }

        System.out.println("Health: " + health);
        if (starsCount > 0) {
            System.out.println("Uncollected stars: " + starsCount);
        }

        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }
}
