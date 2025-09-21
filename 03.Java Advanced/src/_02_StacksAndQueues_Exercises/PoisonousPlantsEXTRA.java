package _02_StacksAndQueues_Exercises;

import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlantsEXTRA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String[] pesticideInput = scanner.nextLine().split(" ");
        int[] pesticides = new int[n];
        for (int i = 0; i < n; i++) {
            pesticides[i] = Integer.parseInt(pesticideInput[i]);
        }


        Stack<int[]> stack = new Stack<>();
        int maxDays = 0;

        for (int i = 0; i < n; i++) {
            int daysToDie = 0;


            while (!stack.isEmpty() && stack.peek()[0] >= pesticides[i]) {
                daysToDie = Math.max(daysToDie, stack.pop()[1]);
            }

            if (!stack.isEmpty()) {
                daysToDie++;
            } else {
                daysToDie = 0;
            }

            maxDays = Math.max(maxDays, daysToDie);
            stack.push(new int[]{pesticides[i], daysToDie});
        }


        System.out.println(maxDays);
    }
}

