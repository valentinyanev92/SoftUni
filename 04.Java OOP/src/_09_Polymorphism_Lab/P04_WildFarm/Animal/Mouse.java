package _09_Polymorphism_Lab.P04_WildFarm.Animal;

import _09_Polymorphism_Lab.P04_WildFarm.Food.Food;
import _09_Polymorphism_Lab.P04_WildFarm.Food.Vegetable;

public class Mouse extends Mammal {

    public Mouse(String animalName, double animalWeight, String livingRegion) {
        super(animalName, "Mouse", animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.foodEaten += food.getQuantity();
        } else {
            System.out.println("Mice are not eating that type of food!");
        }
    }
}
