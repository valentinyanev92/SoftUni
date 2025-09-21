package _02_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        double balance = 0;
        while (!input.equals("Start")){
            double currentCoin = Double.parseDouble(input);
            if (currentCoin==2 || currentCoin==1 || currentCoin==0.5 || currentCoin==0.2 || currentCoin==0.1){
                balance += currentCoin;
            }else {
                System.out.printf("Cannot accept %.2f%n", currentCoin);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")){
            double productPrice = 0;
            switch (input){
                case "Nuts":
                    productPrice = 2;
                    break;
                case "Water":
                    productPrice = 0.7;
                    break;
                case "Crisps":
                    productPrice = 1.5;
                    break;
                case "Soda":
                    productPrice = 0.8;
                    break;
                case "Coke":
                    productPrice = 1;
                    break;
            }
            if (!input.equals("Nuts") && !input.equals("Water") && !input.equals("Crisps") && !input.equals("Soda") && !input.equals("Coke")){
                System.out.println("Invalid product");
            } else if (balance >= productPrice){
                System.out.printf("Purchased %s%n",input);
                balance -= productPrice;
            }else {
                System.out.println("Sorry, not enough money");
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f",balance);
    }
}
