package _17_RegularExpressions_Exercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double spending = 0;
        List<String> itemsBought = new LinkedList<>();
        Pattern pattern = Pattern.compile(">>(?<item>\\w+)<<(?<itemPrice>[0-9]+\\.[0-9]+|[0-9]+)!(?<quantity>\\d+)");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Purchase")) {
                break;
            }

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                spending += Double.parseDouble(matcher.group("itemPrice")) * Double.parseDouble(matcher.group("quantity"));
                itemsBought.add(matcher.group("item"));
            }
        }

        System.out.println("Bought furniture:");
        itemsBought.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", spending);
    }
}
