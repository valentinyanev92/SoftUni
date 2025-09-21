package _14_AssociativeArrays_MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentAcademi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        Map<String, Double> averageGrade = new LinkedHashMap<>();
        for (int i = 0; i < rows; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            averageGrade.putIfAbsent(studentName, grade);
            averageGrade.put(studentName, (averageGrade.get(studentName) + grade) / 2);
        }


        averageGrade = averageGrade.entrySet().stream()
                .filter(entry -> entry.getValue() >= 4.50)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        averageGrade.forEach((studentName, grade) -> System.out.printf("%s -> %.2f%n", studentName, grade));
    }
}
