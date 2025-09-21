package _01_StackAndQueues_LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] participants = scanner.nextLine().split(" ");
        int tosses = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> participantsQueue = new ArrayDeque<>();
        for (int i = 0; i < participants.length; i++) {
            participantsQueue.add(participants[i]);
        }

        int currentCount = 0;
        while (participantsQueue.size() > 1) {
            currentCount++;

            String current = participantsQueue.removeFirst();
            if (currentCount == tosses) {
                System.out.println("Removed " + current);
                currentCount = 0;
            } else {
                participantsQueue.add(current);
            }
        }
        System.out.println("Last is " + participantsQueue.getLast());
    }
}
