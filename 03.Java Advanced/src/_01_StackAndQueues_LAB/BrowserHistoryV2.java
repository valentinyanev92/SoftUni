package _01_StackAndQueues_LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryV2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserHistoryBack = new ArrayDeque<>();
        ArrayDeque<String> browserHistoryForward = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (browserHistoryBack.size() > 1) {
                    browserHistoryForward.push(browserHistoryBack.pop());
                    System.out.println(browserHistoryBack.peek());
                } else {
                    System.out.println("no previous URLs");
                }

            } else if (input.equals("forward")) {

                if (!browserHistoryForward.isEmpty()) {
                    browserHistoryBack.push(browserHistoryForward.pop());
                    System.out.println(browserHistoryBack.peek());
                } else {
                    System.out.println("no next URLs");
                }

            } else {

                browserHistoryBack.push(input);
                browserHistoryForward.clear();
                System.out.println(browserHistoryBack.peek());
            }

            input = scanner.nextLine();
        }
    }
}