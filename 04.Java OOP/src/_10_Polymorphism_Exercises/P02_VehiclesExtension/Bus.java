package _10_Polymorphism_Exercises.P02_VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicles {

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + 1.4, tankCapacity);
    }

    public void drive(double km) {
        double littersNeeded = this.litersPerKm * km;
        DecimalFormat df = new DecimalFormat("#.##");
        if (littersNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= littersNeeded;
            System.out.printf("Bus travelled %s km%n", df.format(km));
        } else {
            System.out.println("Bus needs refueling");
        }
    }
}
