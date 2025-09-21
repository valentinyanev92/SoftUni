package _09_Polymorphism_Lab.P04_WildFarm.Animal;

import _09_Polymorphism_Lab.P04_WildFarm.Food.Food;

public abstract class Animal {
    protected String animalName;
    protected String animalType;
    protected double animalWeight;
    protected int foodEaten;

    public Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);
}
