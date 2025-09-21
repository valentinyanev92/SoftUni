package FinalExam_Official;

import java.util.Scanner;

public class DecryptingCommands {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String message = scanner.nextLine();
        boolean isActive = true;
        while (isActive) {
            String[] input = scanner.nextLine().split(" ");

            switch (input[0]) {
                case "Replace" -> message = Replace(message, input[1], input[2]);
                case "Cut" -> message = Cut(message, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                case "Make" -> message = Make(message, input[1]);
                case "Check" -> Check(message, input[1]);
                case "Sum" -> Sum(message, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                case "Finish" -> isActive = false;
            }
        }
    }

    public static String Replace(String message, String currentChar, String newChar) {
        message = message.replace(currentChar, newChar);
        System.out.println(message);
        return message;
    }

    public static String Cut(String message, int startIndex, int endIndex) {

        String newMessage = "";

        if (startIndex < 0 || startIndex >= message.length() || endIndex < 0 || endIndex >= message.length()) {
            System.out.println("Invalid indices!");
        } else {

            for (int i = 0; i < startIndex; i++) {
                newMessage += message.charAt(i);
            }

            for (int i = endIndex + 1; i < message.length(); i++) {
                newMessage += message.charAt(i);
            }

            System.out.println(newMessage);
            return newMessage;
        }
        return message;
    }

    public static String Make(String message, String operation) {

        switch (operation) {
            case "Upper" -> message = message.toUpperCase();
            case "Lower" -> message = message.toLowerCase();
        }

        System.out.println(message);
        return message;
    }

    public static void Check(String message, String string) {

        if (message.contains(string)) {
            System.out.println("Message contains " + string);
        } else {
            System.out.println("Message doesn't contain " + string);
        }
    }

    public static void Sum(String message, int startIndex, int endIndex) {

        int sum = 0;

        if (startIndex < 0 || startIndex >= message.length() || endIndex < 0 || endIndex >= message.length()) {
            System.out.println("Invalid indices!");
        } else {
            String newMessage = "";

            for (int i = startIndex; i <= endIndex; i++) {
                newMessage += message.charAt(i);
            }

            for (int i = 0; i < newMessage.length(); i++) {
                sum += newMessage.charAt(i);
            }
            System.out.println(sum);
        }
    }
}
