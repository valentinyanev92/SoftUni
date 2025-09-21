package _09_Polymorphism_Lab.P04_WildFarm.Animal;

import _09_Polymorphism_Lab.P04_WildFarm.Food.Food;
import _09_Polymorphism_Lab.P04_WildFarm.Food.Meat;

public class Tiger extends Feline {

    public Tiger(String animalName, double animalWeight, String livingRegion) {
        super(animalName, "Tiger", animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            this.foodEaten += food.getQuantity();
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
