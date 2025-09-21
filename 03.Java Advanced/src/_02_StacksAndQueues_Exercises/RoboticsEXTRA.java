package _02_StacksAndQueues_Exercises;

import java.util.*;

public class RoboticsEXTRA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotInput = scanner.nextLine().split(";");
        Map<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotInput) {
            String[] parts = robotData.split("-");
            String name = parts[0];
            int processTime = Integer.parseInt(parts[1]);
            robots.put(name, processTime);
        }

        String startTime = scanner.nextLine();
        int currentTime = parseTimeToSeconds(startTime);

        Queue<String> products = new LinkedList<>();
        String product;
        while (!(product = scanner.nextLine()).equals("End")) {
            products.add(product);
        }

        Map<String, Integer> robotAvailability = new LinkedHashMap<>();
        for (String robot : robots.keySet()) {
            robotAvailability.put(robot, 0);
        }

        while (!products.isEmpty()) {
            currentTime++;
            product = products.poll();

            boolean isAssigned = false;
            for (Map.Entry<String, Integer> entry : robotAvailability.entrySet()) {
                String robotName = entry.getKey();
                int availableAt = entry.getValue();

                if (currentTime >= availableAt) {
                    System.out.printf("%s - %s [%s]%n", robotName, product, formatTime(currentTime));
                    robotAvailability.put(robotName, currentTime + robots.get(robotName));
                    isAssigned = true;
                    break;
                }
            }

            if (!isAssigned) {
                products.add(product);
            }
        }
    }


    private static int parseTimeToSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }


    private static String formatTime(int seconds) {
        int hours = (seconds / 3600) % 24;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}
