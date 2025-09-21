package _06_Inheritance_Exercises.P05_Restaurant.Beverage;

import java.math.BigDecimal;

public class HotBeverage extends Beverage{
    private double caffeine;

    public HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
        this.caffeine = 0;
    }
}
