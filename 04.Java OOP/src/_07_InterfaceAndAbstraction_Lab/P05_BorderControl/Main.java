package _07_InterfaceAndAbstraction_Lab.P05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> border = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 2) {
                Identifiable robot = new Robot(tokens[0], tokens[1]);
                border.add(robot);
            }else {
                Identifiable citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                border.add(citizen);
            }

            input = scanner.nextLine();
        }

        String fakeIdEnding = scanner.nextLine();
        border.forEach(person -> {
            if (person.getId().endsWith(fakeIdEnding)) {
                System.out.println(person.getId());
            }
        });

    }
}
