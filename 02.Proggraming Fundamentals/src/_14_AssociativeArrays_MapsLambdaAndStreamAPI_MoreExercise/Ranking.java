package _14_AssociativeArrays_MapsLambdaAndStreamAPI_MoreExercise;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> login = new HashMap<>();
        Map<String, Map<String, Integer>> coursesStudent = new TreeMap<>();
        Map<String, Integer> totalGradeByUser = new HashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(":");
            if (input[0].equals("end of contests")) {
                break;
            }
            login.put(input[0], input[1]);
        }

        while (true) {
            String[] input = scanner.nextLine().split("=>");
            if (input[0].equals("end of submissions")) {
                break;
            }

            String course = input[0];
            String password = input[1];
            String name = input[2];
            int grade = Integer.parseInt(input[3]);

            if (login.containsKey(course) && login.get(course).equals(password)) {
                coursesStudent.putIfAbsent(name, new LinkedHashMap<>());
                coursesStudent.get(name).putIfAbsent(course, grade);
                if (coursesStudent.containsKey(name)) {
                    if (coursesStudent.get(name).containsKey(course)) {
                        if (coursesStudent.get(name).get(course) < grade) {
                            coursesStudent.get(name).put(course, grade);
                            totalGradeByUser.put(name, grade);
                        }
                    }

                }
                if (totalGradeByUser.containsKey(name)) {
                    totalGradeByUser.put(name, totalGradeByUser.get(name) + grade);
                } else {
                    totalGradeByUser.put(name, grade);
                }
            }

        }

        for (var entry : coursesStudent.entrySet()) {
            String student = entry.getKey();
            int totalGrade = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            totalGradeByUser.put(student, totalGrade);
        }

        // Извеждане на студента с най-висок резултат
        String bestStudent = Collections.max(totalGradeByUser.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.printf("Best candidate is %s with total %d points.%n", bestStudent, totalGradeByUser.get(bestStudent));

        System.out.println("Ranking:");
        coursesStudent.forEach((name, grade) -> {
            System.out.println(name);
            coursesStudent.get(name).forEach((course, score) -> System.out.printf("# %s -> %d%n", course, score));
        });

    }
}
