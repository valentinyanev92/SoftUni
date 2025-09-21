package _09_Polymorphism_Lab.P04_WildFarm.Animal;

import _09_Polymorphism_Lab.P04_WildFarm.Food.Food;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalName, "Cat", animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Cat[%s, %s, %s, %s, %d]", animalName, breed, df.format(animalWeight), livingRegion, foodEaten);
    }
}
