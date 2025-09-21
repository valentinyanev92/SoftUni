package _05_SetsAndMapsAdvanced_Lab;

import java.util.*;

public class AverageStudentsGrades {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Double>> grades = new TreeMap<>();
        for (int i = 0; i < studentsCount; i++) {
            String[] input = scanner.nextLine().split(" ");

            if (!grades.containsKey(input[0])) {
                grades.put(input[0], new ArrayList<>());
                grades.get(input[0]).add(Double.parseDouble(input[1]));
            } else {
                grades.get(input[0]).add(Double.parseDouble(input[1]));
            }
        }

        grades.forEach((key, value) -> {
            System.out.print(key + " -> ");
            double sum = 0;
            value.forEach(grade -> {
                System.out.printf("%.2f ", grade);
            });

            for (int i = 0; i < value.size(); i++) {
                sum += value.get(i);
            }
             double average = sum / value.size();
            System.out.printf("(avg: %.2f)", average);

            System.out.println();
        });
    }
}
