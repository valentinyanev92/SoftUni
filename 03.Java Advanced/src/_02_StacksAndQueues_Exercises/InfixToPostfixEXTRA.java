package _02_StacksAndQueues_Exercises;

import java.util.*;

public class InfixToPostfixEXTRA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");

        String postfix = convertToPostfix(tokens);

        System.out.println(postfix);
    }

    private static String convertToPostfix(String[] tokens) {
        Stack<String> operatorStack = new Stack<>();
        List<String> postfix = new ArrayList<>();

        Map<String, Integer> precedence = Map.of(
                "+", 1,
                "-", 1,
                "*", 2,
                "/", 2
        );

        for (String token : tokens) {
            if (isOperand(token)) {
                postfix.add(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    postfix.add(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(") &&
                        precedence.get(token) <= precedence.get(operatorStack.peek())) {
                    postfix.add(operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.add(operatorStack.pop());
        }

        return String.join(" ", postfix);
    }

    private static boolean isOperand(String token) {
        return token.matches("[a-z0-9]");
    }
}
