package FinalExam_Exercise;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destinations = scanner.nextLine(); // начален маршрут

        while (true) {
            String[] input = scanner.nextLine().split(":");
            if (input[0].equals("Travel")) {
                break;
            }

            switch (input[0]) {
                case "Add Stop":
                    int addIndex = Integer.parseInt(input[1]);
                    if (addIndex >= 0 && addIndex <= destinations.length()) {
                        StringBuilder destinationAdd = new StringBuilder(destinations);
                        destinationAdd.insert(addIndex, input[2]);
                        destinations = destinationAdd.toString();
                    }
                    System.out.println(destinations);
                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(input[1]);
                    int endIndex = Integer.parseInt(input[2]);
                    if (startIndex >= 0 && startIndex <= endIndex && endIndex < destinations.length()) {
                        StringBuilder destinationRemove = new StringBuilder(destinations);
                        destinationRemove.delete(startIndex, endIndex + 1);
                        destinations = destinationRemove.toString();
                    }
                    System.out.println(destinations);
                    break;

                case "Switch":
                    String oldString = input[1];
                    String newString = input[2];
                    if (destinations.contains(oldString)) {
                        destinations = destinations.replace(oldString, newString);
                    }
                    System.out.println(destinations);
                    break;
            }
        }

        System.out.println("Ready for world tour! Planned stops: " + destinations);
    }
}
