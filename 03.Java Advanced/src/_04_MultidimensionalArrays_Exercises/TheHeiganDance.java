package _04_MultidimensionalArrays_Exercises;

import java.util.Scanner;

public class TheHeiganDance {

    private static final int GRID_SIZE = 15;
    private static final int PLAYER_START_HP = 18500;
    private static final double HEIGAN_HP = 3_000_000;
    private static final int CLOUD_DAMAGE = 3500;
    private static final int ERUPTION_DAMAGE = 6000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double playerDamage = Double.parseDouble(scanner.nextLine());

        double heiganHealth = HEIGAN_HP;
        int playerHealth = PLAYER_START_HP;

        int playerRow = GRID_SIZE / 2;
        int playerCol = GRID_SIZE / 2;

        boolean hasActiveCloud = false;
        String lastSpell = "";

        while (true) {
            heiganHealth -= playerDamage;

            if (hasActiveCloud) {
                playerHealth -= CLOUD_DAMAGE;
                hasActiveCloud = false;
                if (playerHealth <= 0) {
                    lastSpell = "Plague Cloud";
                    break;
                }
            }

            if (heiganHealth <= 0) {
                heiganHealth = 0;
                break;
            }

            String[] spellData = scanner.nextLine().split("\\s+");
            String spell = spellData[0];
            int spellRow = Integer.parseInt(spellData[1]);
            int spellCol = Integer.parseInt(spellData[2]);

            if (isPlayerInDanger(playerRow, playerCol, spellRow, spellCol)) {
                boolean moved = false;

                if (canMove(playerRow - 1, playerCol, spellRow, spellCol)) {
                    playerRow--;
                    moved = true;
                } else if (canMove(playerRow, playerCol + 1, spellRow, spellCol)) {
                    playerCol++;
                    moved = true;
                } else if (canMove(playerRow + 1, playerCol, spellRow, spellCol)) {
                    playerRow++;
                    moved = true;
                } else if (canMove(playerRow, playerCol - 1, spellRow, spellCol)) {
                    playerCol--;
                    moved = true;
                }

                if (!moved) {
                    if (spell.equals("Cloud")) {
                        playerHealth -= CLOUD_DAMAGE;
                        hasActiveCloud = true;
                        lastSpell = "Plague Cloud";
                    } else {
                        playerHealth -= ERUPTION_DAMAGE;
                        lastSpell = "Eruption";
                    }

                    if (playerHealth <= 0) {
                        break;
                    }
                }
            }

            if (playerHealth <= 0) {
                break;
            }
        }

       if (heiganHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        }

        if (playerHealth <= 0) {
            System.out.println("Player: Killed by " + lastSpell);
        } else {
            System.out.println("Player: " + playerHealth);
        }

        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }

    private static boolean isPlayerInDanger(int playerRow, int playerCol, int spellRow, int spellCol) {
        return playerRow >= spellRow - 1 && playerRow <= spellRow + 1 &&
                playerCol >= spellCol - 1 && playerCol <= spellCol + 1;
    }

    private static boolean canMove(int newRow, int newCol, int spellRow, int spellCol) {
        if (newRow < 0 || newRow >= GRID_SIZE || newCol < 0 || newCol >= GRID_SIZE) {
            return false;
        }
        return !isPlayerInDanger(newRow, newCol, spellRow, spellCol);
    }
}
