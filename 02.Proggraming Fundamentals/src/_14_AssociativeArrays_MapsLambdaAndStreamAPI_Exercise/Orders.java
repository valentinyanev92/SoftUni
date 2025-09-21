package _14_AssociativeArrays_MapsLambdaAndStreamAPI_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Product> listForShopping = new HashMap<>();
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("buy")) {
                break;
            }

            if (!listForShopping.containsKey(input[0])) {
                Product product = new Product(input[0], Double.parseDouble(input[1]), Integer.parseInt(input[2]));
                listForShopping.put(input[0], product);
            } else {
                listForShopping.get(input[0]).setQuantity(listForShopping.get(input[0]).getQuantity() + Integer.parseInt(input[2]));
                listForShopping.get(input[0]).setPrice(Double.parseDouble(input[1]));
            }
        }

        listForShopping.forEach(((s, product) -> System.out.printf("%s -> %.2f%n", product.getProductName(), product.getPrice() * product.getQuantity())));
    }

    public static class Product {
        String productName;
        double price;
        int quantity;

        public Product(String productName) {
            this.productName = productName;
        }

        public Product(String productName, double price, int quantity) {
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }
    }
}
