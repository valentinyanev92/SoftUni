package _07_Methods_Lab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        double total = getPrice(product, quantity);
        System.out.printf("%.2f",total);

    }

    private static double getPrice(String product, int quantity) {
        double price = 0;
        switch (product){
            case "coffee":
                price = 1.5;
                break;
            case "water":
                price = 1;
                break;
            case "coke":
                price = 1.4;
                break;
            case "snacks":
                price = 2;
                break;
        }
        price *= quantity;
        return price;
    }
}
