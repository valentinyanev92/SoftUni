package _02_Abstraction_Exercise.P04_TrafficLights;

public class TrafficLights {

    private TrafficLightsColor color;

    public TrafficLights(TrafficLightsColor color) {
        this.color = color;
    }

    public TrafficLightsColor getColor() {
        return this.color;
    }

    public void TrafficLightsChange() {
        if (this.color == TrafficLightsColor.RED) {
            this.color = TrafficLightsColor.GREEN;
        } else if (this.color == TrafficLightsColor.GREEN) {
            this.color = TrafficLightsColor.YELLOW;
        }else {
            this.color = TrafficLightsColor.RED;
        }
    }

    @Override
    public String toString() {
        return this.color.toString();
    }
}
