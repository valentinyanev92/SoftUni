package _04_Encapsulation_Lab.P04_PizzaCalories;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaName = scanner.nextLine().split(" ");
        String[] doughName = scanner.nextLine().split(" ");

        Pizza pizza = null;
        Dough dough = null;
        boolean flag = true;

        try {
            pizza = new Pizza(pizzaName[1], Integer.parseInt(pizzaName[2]));
            dough = new Dough(doughName[1], doughName[2], Double.parseDouble(doughName[3]));
            pizza.setDough(dough);

            String input = scanner.nextLine();
//            int counter = 0;
            while (!input.equals("END")) {
                String[] tokens = input.split("\\s+");
                String topping = tokens[1];
                double weight = Double.parseDouble(tokens[2]);

//                if (counter == Integer.parseInt(pizzaName[2])) {
//                    System.out.println("Topping range");
//                    break;
//                }

                Topping topping1 = new Topping(topping, weight);
                pizza.addTopping(topping1);

//                counter++;
                input = scanner.nextLine();
            }
        } catch (Exception e) {
            flag = false;
            System.out.println(e.getMessage());
        }

        if (flag) {
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        }
    }
}
