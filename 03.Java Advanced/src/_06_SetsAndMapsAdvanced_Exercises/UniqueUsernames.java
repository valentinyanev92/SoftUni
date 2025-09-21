package _06_SetsAndMapsAdvanced_Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Set<String> uniqueUsernames = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            String username = scanner.nextLine();
            uniqueUsernames.add(username);
        }

        uniqueUsernames.forEach(System.out::println);
    }
}
