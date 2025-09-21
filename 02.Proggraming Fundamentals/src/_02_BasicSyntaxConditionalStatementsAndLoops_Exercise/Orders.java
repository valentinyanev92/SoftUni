package _02_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double total = 0;
        for (int i = 0; i < n; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());
            double currentCoffee = ((days*capsuleCount)*pricePerCapsule);
            total += currentCoffee;
            System.out.printf("The price for the coffee is: $%.2f%n", currentCoffee);
        }
        System.out.printf("Total: $%.2f",total);
    }
}
