package _05_SetsAndMapsAdvanced_Lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentGrades = new TreeMap<>();
        for (int s = 0; s < students; s++) {
            String studentName = scanner.nextLine();
            String[] grades = scanner.nextLine().split(" ");

            double averageGrade = 0;
            for (int i = 0; i < grades.length; i++) {
                averageGrade += Double.parseDouble(grades[i]);
            }

            averageGrade /= grades.length;
            studentGrades.put(studentName, averageGrade);
        }

        studentGrades.forEach((studentName, averageGrade) -> {
            System.out.println(studentName + " is graduated with " + averageGrade);
        });

    }
}
