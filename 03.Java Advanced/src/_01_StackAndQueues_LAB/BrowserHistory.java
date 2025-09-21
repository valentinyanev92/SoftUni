package _01_StackAndQueues_LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (browserHistory.size() > 1 ) {
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                browserHistory.push(input);
                System.out.println(browserHistory.peek());
            }

            input = scanner.nextLine();
        }
    }
}
