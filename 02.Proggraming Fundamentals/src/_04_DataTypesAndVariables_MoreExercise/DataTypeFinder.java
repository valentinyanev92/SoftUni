package _04_DataTypesAndVariables_MoreExercise;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            if (isInt(input)) {
                System.out.printf("%s is integer type%n", input);
            } else if (isDouble(input)) {
                System.out.printf("%s is floating point type%n", input);
            } else if (isChar(input)) {
                System.out.printf("%s is character type%n", input);
            } else if (isBoolean(input)) {
                System.out.printf("%s is boolean type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }

        }
    }

    private static boolean isBoolean(String input) {
        return input.equals("true") || input.equals("false");
    }

    private static boolean isChar(String input) {
        return input.length() == 1;
    }

    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return input.contains(".");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
