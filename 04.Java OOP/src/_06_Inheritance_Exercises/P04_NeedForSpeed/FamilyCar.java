package _06_Inheritance_Exercises.P04_NeedForSpeed;

public class FamilyCar extends Car{

    public FamilyCar(double fuel, int horsepower){
        super(fuel, horsepower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
