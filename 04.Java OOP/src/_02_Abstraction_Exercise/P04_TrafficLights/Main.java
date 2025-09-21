package _02_Abstraction_Exercise.P04_TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        List<TrafficLights> trafficLights = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            trafficLights.add(new TrafficLights(TrafficLightsColor.valueOf(input[i])));
        }

        int changes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < changes; i++) {
            trafficLights.forEach(currentTrafficLight -> {
                currentTrafficLight.TrafficLightsChange();
                System.out.print(currentTrafficLight + " ");
            });
            System.out.println();
        }
    }
}
