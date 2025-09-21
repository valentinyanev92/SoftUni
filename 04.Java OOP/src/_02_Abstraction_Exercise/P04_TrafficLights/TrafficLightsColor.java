package _02_Abstraction_Exercise.P04_TrafficLights;

public enum TrafficLightsColor {
    RED(1),
    YELLOW(2),
    GREEN(3);

    private int value;

    TrafficLightsColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
