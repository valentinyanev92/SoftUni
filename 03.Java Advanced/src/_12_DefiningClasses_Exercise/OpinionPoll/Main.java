package _12_DefiningClasses_Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String[] person = scanner.nextLine().split("\\s+");
            String name = person[0];
            int age = Integer.parseInt(person[1]);

            Person p = new Person(name, age);
            personList.add(p);
        }

        List<Person> persons = personList.stream().filter(p -> p.getAge() > 30).collect(Collectors.toList());
        persons.sort(Comparator.comparing(Person::getName));
        for (Person p : persons) {
            System.out.println(p);
        }

    }
}
