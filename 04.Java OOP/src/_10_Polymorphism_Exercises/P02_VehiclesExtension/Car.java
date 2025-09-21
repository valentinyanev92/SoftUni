package _10_Polymorphism_Exercises.P02_VehiclesExtension;

import java.text.DecimalFormat;

public class Car extends Vehicles {

    public Car(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + 0.9, tankCapacity);
    }

    public void drive(double km) {
        double littersNeeded = this.litersPerKm * km;
        DecimalFormat df = new DecimalFormat("#.##");
        if (littersNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= littersNeeded;
            System.out.printf("Car travelled %s km%n", df.format(km));
        } else {
            System.out.println("Car needs refueling");
        }
    }
}
