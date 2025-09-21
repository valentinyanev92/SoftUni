package _09_FunctionalProgramming_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        scanner.close();

        List<String> uppercaseWords = new ArrayList<>();
        int counter = 0;
        Predicate<String> uppercaseWord = word -> {
            if (IsUpperCase(word.charAt(0))){
                return true;
            }
            return false;
        };
        for (String word : words) {
            if (uppercaseWord.test(word)) {
                uppercaseWords.add(word);
                counter++;
            }
        }

        System.out.println(counter);
        uppercaseWords.forEach(System.out::println);
    }

    private static boolean IsUpperCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        } else {
            return false;
        }
    }
}
