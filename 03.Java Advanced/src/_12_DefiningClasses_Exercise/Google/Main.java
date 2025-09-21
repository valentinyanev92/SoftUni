package _12_DefiningClasses_Exercise.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] data = input.split("\\s+");
            String personName = data[0];
            String category = data[1];

            people.putIfAbsent(personName, new Person(personName));
            Person person = people.get(personName);

            switch (category) {
                case "company":
                    person.setCompany(data[2], data[3], Double.parseDouble(data[4]));
                    break;
                case "car":
                    person.setCar(data[2], Integer.parseInt(data[3]));
                    break;
                case "pokemon":
                    person.addPokemon(data[2], data[3]);
                    break;
                case "parents":
                    person.addParent(data[2], data[3]);
                    break;
                case "children":
                    person.addChild(data[2], data[3]);
                    break;
            }
        }

        String targetPerson = scanner.nextLine();
        System.out.println(people.get(targetPerson));
    }
}
