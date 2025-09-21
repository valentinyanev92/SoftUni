package _12_SOLID_Exercises.products.food;

public class Cloud implements Food {

    @Override
    public double getCalories() {
        throw new UnsupportedOperationException("Clouds do not have a calories!");
    }

    @Override
    public double getKilograms() {
        return 500000;
    }
}
