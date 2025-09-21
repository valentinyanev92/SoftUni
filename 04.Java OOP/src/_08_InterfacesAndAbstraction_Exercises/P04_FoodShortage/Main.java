package _08_InterfacesAndAbstraction_Exercises.P04_FoodShortage;

import _08_InterfacesAndAbstraction_Exercises.P04_FoodShortage.Classes.Citizen;
import _08_InterfacesAndAbstraction_Exercises.P04_FoodShortage.Classes.Rebel;
import _08_InterfacesAndAbstraction_Exercises.P04_FoodShortage.Interface.Buyer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> people = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input.length == 4) {
                people.put(input[0], new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3] ));
            }else {
                people.put(input[0], new Rebel(input[0], Integer.parseInt(input[1]), input[2]));
            }
        }

        String person = scanner.nextLine();
        while (!person.equals("End")) {
            if (people.containsKey(person)) {
                Buyer buyer = people.get(person);
                buyer.buyFood();
            }
            person = scanner.nextLine();
        }

        AtomicInteger foodCounter = new AtomicInteger();
        people.entrySet().stream().forEach(entry -> {
            foodCounter.addAndGet(entry.getValue().getFood());
        });
        System.out.println(foodCounter);
    }
}
