package _14_AssociativeArrays_MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> examResults = new LinkedHashMap<>();
        Map<String, Integer> languages = new LinkedHashMap<>();
        while (true) {
            String[] input = scanner.nextLine().split("-");

            if (input[0].equals("exam finished")) {
                break;
            }

            if (input[1].equals("banned")) {
                examResults.remove(input[0]);
            } else {
                String name = input[0];
                String language = input[1];
                int points = Integer.parseInt(input[2]);
                boolean checkForExist = examResults.containsKey(name);

                if(checkForExist){
                    if (examResults.get(name)<points){
                        examResults.put(name,points);
                    }
                }else {
                    examResults.put(name,points);
                }

                if (languages.containsKey(language)) {
                    languages.put(language, languages.get(language) + 1);
                } else {
                    languages.put(language, 1);
                }
            }
        }
        System.out.println("Results:");
        examResults.forEach((n, g) -> System.out.printf("%s | %d%n", n, g));
        System.out.println("Submissions:");
        languages.forEach((l, s) -> System.out.printf("%s - %d%n", l, s));
    }
}
