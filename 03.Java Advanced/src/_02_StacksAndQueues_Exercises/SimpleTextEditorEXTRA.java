package _02_StacksAndQueues_Exercises;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditorEXTRA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());


        StringBuilder text = new StringBuilder();
        Stack<String> history = new Stack<>();


        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().split(" ");
            String commandType = commandParts[0];

            switch (commandType) {
                case "1":
                    history.push(text.toString());
                    text.append(commandParts[1]);
                    break;

                case "2":
                    history.push(text.toString());
                    int count = Integer.parseInt(commandParts[1]);
                    text.delete(text.length() - count, text.length());
                    break;

                case "3":
                    int index = Integer.parseInt(commandParts[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;

                case "4":
                    if (!history.isEmpty()) {
                        text = new StringBuilder(history.pop());
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Invalid command type: " + commandType);
            }
        }
    }
}
