package _03_Encapsulation_Lab.P01_SortByNameAndAge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < persons; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            personList.add(new Person(input[0], input[1], Integer.parseInt(input[2]) ));
        }

        Collections.sort(personList, (firstPerson, secondPerson) -> {
            int compare = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (compare != 0) {
                return compare;
            }else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        personList.forEach(System.out::println);
    }
}
