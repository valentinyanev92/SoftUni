package _12_SOLID_Exercises.products.food;

import _12_SOLID_Exercises.products.Product;

public class Chips implements Product, Food {

    public static final double CALORIES_PER_100_GRAMS = 529.0;

    private double grams;

    public double getGrams() {
        return grams;
    }

    @Override
    public double getCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * getGrams();
    }

    @Override
    public double getKilograms() {
        return getGrams() / 1000;
    }
}
