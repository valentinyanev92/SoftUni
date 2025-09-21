package _02_StacksAndQueues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }

                char lastOpen = stack.pop();
                if (!matches(lastOpen, ch)) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(stack.isEmpty() ? "YES" : "NO");
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
