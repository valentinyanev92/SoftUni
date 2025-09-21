package _02_StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumberWithStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).forEach(n -> stack.push(Integer.parseInt(n)));

        stack.forEach(n -> System.out.print(n + " "));
    }
}
