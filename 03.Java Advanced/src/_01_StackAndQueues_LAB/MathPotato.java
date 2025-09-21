package _01_StackAndQueues_LAB;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> kids = new PriorityQueue<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(kids::offer);

        int rorations = 0;

        while (kids.size() > 1) {
            String current = kids.poll();
            rorations++;

            if (isPrime(rorations)) {
                System.out.println("Prime " + current);
                kids.offer(current);
            } else {
                System.out.println("Removed " + current);
            }
        }
        System.out.println("Last is " + kids.peek());
    }

    private static boolean isPrime(int number) {

        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
