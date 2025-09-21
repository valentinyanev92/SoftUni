package _10_Polymorphism_Exercises.P02_VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicles {
    protected double fuelQuantity;
    protected double litersPerKm;
    protected double tankCapacity;

    protected Vehicles(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
        this.tankCapacity = tankCapacity;
    }

    public void refuel(double liters){
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            double difference = tankCapacity - fuelQuantity;
            if (liters > difference) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                this.fuelQuantity += liters;
            }
        }
    }

    abstract void drive(double km);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    public void driveEmpty(double km) {
        double littersNeeded = (this.litersPerKm - 1.4) * km;
        DecimalFormat df = new DecimalFormat("#.##");
        if (littersNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= littersNeeded;
            System.out.printf("Bus travelled %s km%n", df.format(km));
        } else {
            System.out.println("Bus needs refueling");
        }
    }
}
