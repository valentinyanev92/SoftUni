package _09_Polymorphism_Lab.P04_WildFarm;

import _09_Polymorphism_Lab.P04_WildFarm.Animal.*;
import _09_Polymorphism_Lab.P04_WildFarm.Food.Food;
import _09_Polymorphism_Lab.P04_WildFarm.Food.Meat;
import _09_Polymorphism_Lab.P04_WildFarm.Food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        while (true) {
            String animalInput = scanner.nextLine();
            if (animalInput.equals("End")) {
                break;
            }
            String foodInput = scanner.nextLine();

            String[] animalData = animalInput.split(" ");
            String[] foodData = foodInput.split(" ");

            Animal animal = null;
            Food food = foodData[0].equals("Vegetable") ? new Vegetable(Integer.parseInt(foodData[1])) : new Meat(Integer.parseInt(foodData[1]));

            switch (animalData[0]) {
                case "Mouse":
                    animal = new Mouse(animalData[1], Double.parseDouble(animalData[2]), animalData[3]);
                    break;
                case "Zebra":
                    animal = new Zebra(animalData[1], Double.parseDouble(animalData[2]), animalData[3]);
                    break;
                case "Cat":
                    animal = new Cat(animalData[1], Double.parseDouble(animalData[2]), animalData[3], animalData[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(animalData[1], Double.parseDouble(animalData[2]), animalData[3]);
                    break;
            }

            if (animal != null) {
                animals.add(animal);
                animal.makeSound();
                animal.eat(food);
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}