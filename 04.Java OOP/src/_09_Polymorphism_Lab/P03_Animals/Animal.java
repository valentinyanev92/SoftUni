package _09_Polymorphism_Lab.P03_Animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public final String getName() {
        return name;
    }

    public final String getFavouriteFood() {
        return favouriteFood;
    }

    public String explainSelf(){
        return String.format("I am %s and my favorite food is %s%n",this.getName(),this.getFavouriteFood());
    }
}
