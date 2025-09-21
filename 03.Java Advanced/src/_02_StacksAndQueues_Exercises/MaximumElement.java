package _02_StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> elements = new ArrayDeque<>();
        PriorityQueue<Integer> elements2 = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < commands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int operation = Integer.parseInt(input[0]);

            switch (operation){
                case 1: {
                    int number = Integer.parseInt(input[1]);
                    elements.offer(number);
                    break;
                }
                case 2: elements.removeLast(); break;
                case 3:
                    elements.forEach(elements2::offer);
                    System.out.println(elements2.peek());
                    elements2.clear();
                    break;
                default: break;
            }

        }
    }
}
