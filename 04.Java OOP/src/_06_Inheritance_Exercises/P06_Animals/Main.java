package _06_Inheritance_Exercises.P06_Animals;

import _06_Inheritance_Exercises.P06_Animals.Animals.Animal;
import _06_Inheritance_Exercises.P06_Animals.Animals.Cat.Cat;
import _06_Inheritance_Exercises.P06_Animals.Animals.Cat.Kitten;
import _06_Inheritance_Exercises.P06_Animals.Animals.Cat.Tomcat;
import _06_Inheritance_Exercises.P06_Animals.Animals.Dog.Dog;
import _06_Inheritance_Exercises.P06_Animals.Animals.Frog.Frog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        while (true) {
            String type = scanner.nextLine();

            if (type.equals("Beast!")) {
                break;
            }
            String[] animalInfo = scanner.nextLine().split("\\s+");

            try {
                animals.add(createAnimal(type, animalInfo));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        animals.forEach(animal -> {
            System.out.println(animal.toString());
            System.out.println(animal.produceSound());
        });
    }

    private static Animal createAnimal(String type, String[] info) {
        String name = info[0];
        int age = Integer.parseInt(info[1]);

        switch (type) {
            case "Cat":
                return new Cat(name, age, info[2]);
            case "Dog":
                return new Dog(name, age, info[2]);
            case "Frog":
                return new Frog(name, age, info[2]);
            case "Kitten":
                return new Kitten(name, age);
            case "Tomcat":
                return new Tomcat(name, age);
            default:
                throw new IllegalArgumentException("Invalid input!");
        }
    }
}