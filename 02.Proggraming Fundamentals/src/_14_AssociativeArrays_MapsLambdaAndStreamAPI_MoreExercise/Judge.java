package _14_AssociativeArrays_MapsLambdaAndStreamAPI_MoreExercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contest = new LinkedHashMap<>();
        Map<String, Integer> studentsPoints = new LinkedHashMap<>();
        while (true) {
            String in = scanner.nextLine();
            if (in.equals("no more time")) {
                break;
            }

            String[] input = in.split(" -> ");
            String student = input[0];
            String course = input[1];
            int points = Integer.parseInt(input[2]);

            Map<String, Integer> mid = new HashMap<>();
            mid.put(student, points);

            contest.putIfAbsent(course, mid);
            if (contest.get(course).containsKey(student)) {
                if (contest.get(course).get(student) < points) {
                    contest.get(course).replace(student, points);
                }
            } else {
                contest.get(course).put(student, points);
            }
        }

        contest.forEach((course, students) -> {
            contest.get(course).forEach((student, grade) -> {
                if (studentsPoints.containsKey(student)) {
                    studentsPoints.replace(student, studentsPoints.get(student) + grade);
                } else {
                    studentsPoints.putIfAbsent(student, grade);
                }
            });
        });

        // TODO : SORT

        contest.forEach((course, students) -> {
            System.out.printf("%s: %d participants%n", course, contest.get(course).size());
            final Integer[] count = {1};
            contest.get(course).forEach((student, grade) -> {
                System.out.printf("%d. %s <::> %d%n", count[0], student, grade);
                count[0]++;
            });
            System.out.println();
            count[0] = 1;
        });

        System.out.printf("%nIndividual standings:%n");
        studentsPoints.forEach((student, points) -> {
            System.out.printf("%s -> %d%n", student, points);
        });

    }
}
