package _08_InterfacesAndAbstraction_Exercises.P03_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();
        while (!input[0].equals("End")) {

            if (input.length == 5) {
                citizens.add(new Citizen(input[1], Integer.parseInt(input[2]), input[3], input[4]));
            } else {
                if (input[0].equals("Pet")) {
                    pets.add(new Pet(input[1], input[2]));
                } else {
                    robots.add(new Robot(input[1], input[2]));
                }
            }
            input = scanner.nextLine().split("\\s+");
        }

        String searchedYear = scanner.nextLine();
        citizens.forEach((citizen) -> {
            if (citizen.getBirthDate().endsWith(searchedYear)) {
                System.out.println(citizen.getBirthDate());
            }
        });
        pets.forEach((pet) -> {
            if (pet.getBirthDate().endsWith(searchedYear)) {
                System.out.println(pet.getBirthDate());
            }
        });
    }
}
