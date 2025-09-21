package _10_Polymorphism_Exercises.P01_Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicles{

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + 1.6);
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters * 0.95;
    }

    public void drive(double km) {
        double littersNeeded = litersPerKm * km;
        DecimalFormat df = new DecimalFormat("#.##");
        if (littersNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= littersNeeded;
            System.out.printf("Truck travelled %s km%n", df.format(km));
        }else {
            System.out.println("Truck needs refueling");
        }
    }
}
