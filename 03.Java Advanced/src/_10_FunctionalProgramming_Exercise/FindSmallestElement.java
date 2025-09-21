package _10_FunctionalProgramming_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class FindSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] tokens = input.trim().split("\\s+");

        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }

        Function<List<Integer>, Integer> findSmallestIndex = list -> {
            int smallest = list.get(0);
            int index = 0;

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) <= smallest) {
                    smallest = list.get(i);
                    index = i;
                }
            }

            return index;
        };

        int smallestIndex = findSmallestIndex.apply(numbers);

        System.out.println(smallestIndex);
    }
}
