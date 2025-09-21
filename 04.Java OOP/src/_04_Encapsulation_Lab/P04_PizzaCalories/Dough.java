package _04_Encapsulation_Lab.P04_PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White" -> this.flourType = "White";
            case "Wholegrain" -> this.flourType = "Wholegrain";
            default -> throw new IllegalArgumentException("Invalid type of dough");
        }

//        if (flourType.equals("White")) {
//            this.setFlourType("White");
//        } else if (flourType.equals("Wholegrain")) {
//            this.setFlourType("Wholegrain");
//        } else {
//            throw new IllegalArgumentException("Invalid type of dough.");
//        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy" -> this.bakingTechnique = "Crispy";
            case "Chewy" -> this.bakingTechnique = "Chewy";
            case "Homemade" -> this.bakingTechnique = "Homemade";
            default -> throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200]");
        }
    }

    public String getFlourType() {
        return this.flourType;
    }

    public String getBakingTechnique() {
        return this.bakingTechnique;
    }

    public double getWeight() {
        return this.weight;
    }

    public double calculateCalories() {
        double typeModifier = 1;
        double bakingModifier = 1;

        if (this.flourType.equals("White")) {
            typeModifier = 1.5;
        }

        switch (this.getBakingTechnique()) {
            case "Crispy" -> bakingModifier = 0.9;
            case "Chewy" -> bakingModifier = 1.1;
        }

        return typeModifier * bakingModifier * this.getWeight() * 2;
    }
}
