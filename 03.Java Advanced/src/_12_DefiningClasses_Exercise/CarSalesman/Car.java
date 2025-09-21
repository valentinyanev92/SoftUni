package _12_DefiningClasses_Exercise.CarSalesman;

public class Car {

    String model;
    Engine engine;
    int weight;
    String color;


    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.weight = -1;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String format;
        if (weight != -1) {
            format = model + ":\n" +
                    engine.toString() + "\n" +
                    "Weight: " + weight + "\n"
                    + "Color: " + color;
            return format;
        } else {
            format = model + ":\n" +
                    engine.toString() + "\n" +
                    "Weight: n/a" + "\n"
                    + "Color: " + color;
            return format;
        }
    }
}
