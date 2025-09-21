package _10_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PredicateForNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).toList();

        names.forEach(name -> {
            if (name.length() <= length) {
                System.out.println(name);
            }
        });
    }
}
