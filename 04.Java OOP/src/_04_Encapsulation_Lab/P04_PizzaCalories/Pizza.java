package _04_Encapsulation_Lab.P04_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int toppings) {
        this.setName(name);
        this.setToppings(toppings);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        } else if (name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    private void setToppings(int toppings) {
        if (toppings >= 1 && toppings <= 10) {
            this.toppings = new ArrayList<>(toppings);
        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void addTopping(Topping topping) {
        this.getToppings().add(topping);
    }

    public double getOverallCalories() {
        double toppingCalories = 0;
        double doughCalories = this.getDough().calculateCalories();

        for (Topping topping : this.getToppings()) {
            toppingCalories += topping.calculateCalories();
        }

        return toppingCalories + doughCalories;
    }
}
