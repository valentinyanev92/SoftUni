package MidExam_Exercise;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        while (true) {
            String action = scanner.nextLine();

            if (action.equals("Registration")) {
                break;
            }

            StringBuilder builder = new StringBuilder(username);
            String[] actionArray = action.split(" ");
            switch (actionArray[0]) {
                case "Letters":
                    if (actionArray[1].equals("Lower")) {
                        builder = new StringBuilder(username.toLowerCase());
                        System.out.println(builder);
                        username = builder.toString();

                    } else {
                        builder = new StringBuilder(username.toUpperCase());
                        System.out.println(builder);
                        username = builder.toString();
                    }
                    break;

                case "Reverse":
                    int beginReverse = Integer.parseInt(actionArray[1]);
                    int endReverse = Integer.parseInt(actionArray[2]) + 1;
                    if (beginReverse < 0 || beginReverse > builder.capacity() || endReverse < 0 || endReverse > builder.capacity()) {
                        break;
                    } else {
                        StringBuilder reverse = new StringBuilder(username);
                        StringBuilder reversePhrase = new StringBuilder(username.substring(beginReverse, endReverse)).reverse();
                        reverse.replace(beginReverse, endReverse, reversePhrase.toString());
//                        System.out.println(reverse);
                        System.out.println(reversePhrase);
                    }
                    break;

                case "Substring":
                    String substring = actionArray[1];
                    if (username.contains(substring)) {
                        StringBuilder substringStrBuilder = new StringBuilder(username);
                        int begin = substringStrBuilder.indexOf(substring);
                        for (int i = 0; i <= begin; i++) {
                            substringStrBuilder.deleteCharAt(begin);
                        }
                        System.out.println(substringStrBuilder);
                        username = substringStrBuilder.toString();
                    } else {
                        System.out.printf("The username %s doesn't contain %s.%n", username, substring);

                    }
                    break;

                case "Replace":
                    StringBuilder replaced = new StringBuilder(username);
                    for (int i = 0; i < replaced.length(); i++) {
                        if (replaced.charAt(i) == actionArray[1].charAt(0)) {
                            replaced.deleteCharAt(i);
                            replaced.insert(i,"-");
                        }
                    }
                    System.out.println(replaced);
                    username = replaced.toString();
                    break;

                case "IsValid":
                    if (username.contains(actionArray[1])) {
                        System.out.println("Valid username");
                    } else {
                        System.out.println(actionArray[1] + " must be contained in your username.");
                    }

                    break;
            }

        }
    }
}
