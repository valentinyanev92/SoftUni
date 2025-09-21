package _10_Polymorphism_Exercises.P01_Vehicles;

public abstract class Vehicles {
    protected double fuelQuantity;
    protected double litersPerKm;

    protected Vehicles(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
    }

    abstract void refuel(double liters);
    abstract void drive(double km);

    @Override
    public String toString() {
//        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
