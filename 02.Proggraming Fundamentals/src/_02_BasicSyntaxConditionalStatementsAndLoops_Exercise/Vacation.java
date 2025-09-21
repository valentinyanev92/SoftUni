package _02_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();

        double pricePerPerson = 0;
        double discount = 1;
        switch (groupType) {
            case "Students":
                switch (day) {
                    case "Friday" -> pricePerPerson = 8.45;
                    case "Saturday" -> pricePerPerson = 9.80;
                    case "Sunday" -> pricePerPerson = 10.46;
                }
                if (persons >= 30) {
                    discount = 0.85;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday" -> pricePerPerson = 10.9;
                    case "Saturday" -> pricePerPerson = 15.6;
                    case "Sunday" -> pricePerPerson = 16;
                }
                if (persons >= 100) {
                    persons -= 10;
                }
                break;
            case "Regular":
                pricePerPerson = switch (day) {
                    case "Friday" -> 15;
                    case "Saturday" -> 20;
                    case "Sunday" -> 22.5;
                    default -> pricePerPerson;
                };
                if (persons >= 10 && persons <= 20) {
                    discount = .95;
                }
                break;
        }

        double total = (persons*pricePerPerson)*discount;
        System.out.printf("Total price: %.2f",total);
    }
}
