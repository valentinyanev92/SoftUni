package _12_SOLID_Exercises.calculator;


import _12_SOLID_Exercises.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator{

    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            sum += product.getCalories();
        }

        return sum;
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
