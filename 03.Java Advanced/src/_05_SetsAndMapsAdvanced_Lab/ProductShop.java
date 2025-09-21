package _05_SetsAndMapsAdvanced_Lab;

import java.util.*;

public class ProductShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shops = new TreeMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Revision")) {
                break;
            }

            String[] tokens = input.split(", ");
            if (tokens.length != 3) {
                continue;
            }

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());

            shops.get(shop).put(product, price);
        }

        shops.forEach((shop, products) -> {
            System.out.println(shop + "->");
            products.forEach((product, price) -> {
                System.out.printf("Product: %s, Price: %.1f%n", product, price);
            });
        });
    }
}
