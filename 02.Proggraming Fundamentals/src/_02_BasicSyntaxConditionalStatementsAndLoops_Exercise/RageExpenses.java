package _02_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gamesLost = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double rageExpenses = 0;
        int keyboardBroken = 0;
        for (int i = 1; i <=  gamesLost; i++) {
             if (i % 2== 0){
                 rageExpenses += headsetPrice;
             }
             if (i % 3== 0){
                 rageExpenses += mousePrice;
             }
             if (i % 2==0 && i % 3 ==0){
                 rageExpenses += keyboardPrice;
                 keyboardBroken++;
                 if (keyboardBroken%2==0){
                     rageExpenses += displayPrice;
                 }
             }

        }
        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }
}
