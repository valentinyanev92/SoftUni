package _09_Polymorphism_Lab.P04_WildFarm.Food;

public abstract class Food {
    protected int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}
