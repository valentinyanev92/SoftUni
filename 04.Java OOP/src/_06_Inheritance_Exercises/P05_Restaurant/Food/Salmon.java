package _06_Inheritance_Exercises.P05_Restaurant.Food;

import java.math.BigDecimal;

public class Salmon extends MainDish{
    final static double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price, double grams){
        super(name, price, SALMON_GRAMS);
    }
}
