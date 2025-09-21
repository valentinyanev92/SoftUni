package _12_DefiningClasses_Exercise.CarSalesman;

public class Engine {

    String model;
    int power;
    int displacement;
    String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
        this.displacement = -1;
    }

    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String format;
        if (displacement == -1) {
            format = model + ":\n" +
                    "Power: " + power + "\n" +
                    "Displacement: n/a\n" +
                    "Efficiency: " + efficiency;
            return format;
        } else {
            format = model + ":\n" +
                    "Power: " + power + "\n" +
                    "Displacement: " + displacement + "\n" +
                    "Efficiency: " + efficiency;
            return format;
        }
    }
}
