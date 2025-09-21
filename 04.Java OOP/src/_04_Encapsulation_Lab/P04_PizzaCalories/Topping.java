package _04_Encapsulation_Lab.P04_PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        switch (toppingType){
            case "Meat" -> this.toppingType = "Meat";
            case "Veggies" -> this.toppingType = "Veggies";
            case "Cheese" -> this.toppingType = "Cheese";
            case "Sauce" -> this.toppingType = "Sauce";
            default -> throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight >=1 && weight <=50){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException(this.getToppingType() + " weight should be in range [1..50].");
        }
    }

    public double calculateCalories() {
        double multiplier = 1;
        switch (this.getToppingType()){
            case "Meat" -> multiplier = 1.2;
            case "Veggies" -> multiplier = 0.8;
            case "Cheese" -> multiplier = 1.1;
            case "Sauce" -> multiplier = 0.9;
        }

        return (this.getWeight() * 2) * multiplier;
    }


}
