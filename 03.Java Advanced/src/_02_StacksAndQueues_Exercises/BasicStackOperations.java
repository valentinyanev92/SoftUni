package _02_StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int elementsToPush = Integer.parseInt(input[0]);
        int elementsToPop = Integer.parseInt(input[1]);
        int searchedElement = Integer.parseInt(input[2]);

        String[] elements = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < elementsToPush; i++) {
            stack.push(Integer.parseInt(elements[i]));
        }

        for (int i = 0; i < elementsToPop; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(searchedElement)) {
            System.out.println("true");
        } else {
            int minElement = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                int current = stack.pop();
                if (current < minElement) {
                    minElement = current;
                }
            }
            System.out.println(minElement);
        }
    }
}