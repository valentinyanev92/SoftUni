package _12_DefiningClasses_Exercise.Google;

public class Car {
    String model;
    int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return model + " " + speed;
    }
}
