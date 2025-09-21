package _01_StackAndQueues_LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {

                if (printerQueue.peek() == null) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.pop());
                }

            } else {
                printerQueue.offer(input);
            }
            input = scanner.nextLine();
        }

        printerQueue.forEach(System.out::println);
    }
}