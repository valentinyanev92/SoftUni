package _06_Inheritance_Exercises.P04_NeedForSpeed;

public class CrossMotorcycle extends Motorcycle{

    public CrossMotorcycle(double fuel, int horsepower) {
        super(fuel, horsepower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
