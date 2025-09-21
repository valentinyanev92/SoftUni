package _02_BasicSyntaxConditionalStatementsAndLoops_MoreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budged = Double.parseDouble(scanner.nextLine());
        double moneySpend = 0;
        String input = scanner.nextLine();
        while (!input.equals("Game Time")) {
            boolean isGameExist = true;
            double gamePrice = 0;
            switch (input) {
                case "OutFall 4" -> gamePrice = 39.99;
                case "CS: OG" -> gamePrice = 15.99;
                case "Zplinter Zell" -> gamePrice = 19.99;
                case "Honored 2" -> gamePrice = 59.99;
                case "RoverWatch" -> gamePrice = 29.99;
                case "RoverWatch Origins Edition" -> gamePrice = 39.99;
                default -> isGameExist = false;
            }
            if (!isGameExist) {
                System.out.println("Not Found");
                input = scanner.nextLine();
            } else {
                if (budged == 0) {
                    System.out.println("Out of money!");
                    break;
                }
                if (gamePrice > budged) {
                    System.out.println("Too Expensive");
                } else {
                    budged -= gamePrice;
                    moneySpend += gamePrice;
                    System.out.println("Bought " + input);
                    if (budged == 0) {
                        System.out.println("Out of money!");
                        break;
                    }
                }

                input = scanner.nextLine();
            }
        }
        if (budged > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneySpend, budged);
        }
    }
}
