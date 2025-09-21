package _10_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = num -> divisors.stream().allMatch(div -> num % div == 0);

        List<Integer> result = IntStream.rangeClosed(1, n)
                .filter(isDivisible::test)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
