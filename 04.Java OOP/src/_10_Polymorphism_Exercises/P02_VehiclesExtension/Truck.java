package _10_Polymorphism_Exercises.P02_VehiclesExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicles{

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + 1.6, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        liters *= 0.95;
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

    public void drive(double km) {
        double littersNeeded = this.litersPerKm * km;
        DecimalFormat df = new DecimalFormat("#.##");
        if (littersNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= littersNeeded;
            System.out.printf("Truck travelled %s km%n", df.format(km));
        }else {
            System.out.println("Truck needs refueling");
        }
    }
}
