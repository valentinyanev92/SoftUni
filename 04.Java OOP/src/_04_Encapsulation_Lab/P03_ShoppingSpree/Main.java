package _04_Encapsulation_Lab.P03_ShoppingSpree;

import java.util.*;

public class Main {

    public static void main(String[] args) {Scanner scanner = new Scanner(System.in);
        try {
            Map<String, Person> persons = new LinkedHashMap<>();
            Map<String, Product> products = new HashMap<>();

            String[] peopleInput = scanner.nextLine().split(";");
            for (String p : peopleInput) {
                String[] data = p.split("=");
                persons.put(data[0], new Person(data[0], Double.parseDouble(data[1])));
            }

            String[] productsInput = scanner.nextLine().split(";");
            for (String pr : productsInput) {
                String[] data = pr.split("=");
                products.put(data[0], new Product(data[0], Double.parseDouble(data[1])));
            }

            String input;
            while (!(input = scanner.nextLine()).equals("END")) {
                String[] command = input.split(" ");
                String personName = command[0];
                String productName = command[1];
                try {
                    persons.get(personName).buyProduct(products.get(productName));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            for (Person person : persons.values()) {
                System.out.print(person.getName() + " - ");
                List<Product> personProducts = person.getProducts();
                if (personProducts.isEmpty()) {
                    System.out.println("Nothing bought");
                } else {
                    for (int i = 0; i < personProducts.size(); i++) {
                        if (i == personProducts.size() - 1) {
                            System.out.println(personProducts.get(i).getName());
                        } else {
                            System.out.println(personProducts.get(i).getName() + ", ");
                        }
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
