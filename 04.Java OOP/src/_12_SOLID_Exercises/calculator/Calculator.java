package _12_SOLID_Exercises.calculator;

import _12_SOLID_Exercises.products.Product;

import java.util.List;

public interface Calculator {

    double sum(List<Product> products);
    double average(List<Product> products);
}
