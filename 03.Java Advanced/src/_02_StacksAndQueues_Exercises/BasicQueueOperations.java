package _02_StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int elementsToAdd = Integer.parseInt(input[0]);
        int elementsToPoll = Integer.parseInt(input[1]);
        int searchedElement = Integer.parseInt(input[2]);

        String[] elements = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < elementsToAdd; i++) {
            stack.offer(Integer.parseInt(elements[i]));
        }

        for (int i = 0; i < elementsToPoll; i++) {
            if (!stack.isEmpty()) {
                stack.poll();
            }
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(searchedElement)) {
            System.out.println("true");
        } else {
            int minElement = Integer.MAX_VALUE;
            boolean found = false;
            while (!stack.isEmpty()) {
                int current = stack.pop();
                if (current < minElement) {
                    minElement = current;
                }
                if (current % searchedElement == 0) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println(found);
            } else {
                System.out.println(minElement);
            }
        }
    }
}
