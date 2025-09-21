package _09_Polymorphism_Lab.P04_WildFarm.Animal;

import _09_Polymorphism_Lab.P04_WildFarm.Food.Food;
import _09_Polymorphism_Lab.P04_WildFarm.Food.Vegetable;

public class Zebra extends Mammal{

    public Zebra(String animalName, double animalWeight, String livingRegion) {
        super(animalName, "Zebra", animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.foodEaten += food.getQuantity();
        } else {
            System.out.println("Zebras are not eating that type of food!");
        }
    }
}
