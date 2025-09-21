package FinalExam_Exercise;

import java.util.Scanner;

public class ActivationKeys {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String key = scanner.nextLine();

        boolean isFinish = true;
        while (isFinish) {
            String[] input = scanner.nextLine().split(">>>");
            switch (input[0]) {
                case "Contains" -> Contains(key, input[1]);
                case "Flip" -> key = Flip(key, input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                case "Slice" -> key = Slice(key, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                case "Generate" -> {
                    isFinish = false;
                }
            }
        }

        System.out.println("Your activation key is: " + key);
    }

    public static void Contains(String key, String searchString) {

        if (key.contains(searchString)) {
            System.out.println(key + " contains " + searchString);
        } else {
            System.out.println("Substring not found!");
        }
    }

    public static String Flip(String key, String operation, int startIndex, int endIndex) {

        switch (operation) {
            case "Upper" -> {
                String upper = "";
                for (int i = startIndex; i < endIndex; i++) {
                    upper += key.charAt(i);
                }
                upper = upper.toUpperCase();
                StringBuilder newKey = new StringBuilder();

                for (int i = 0; i < startIndex; i++) {
                    newKey.append(key.charAt(i));
                }
                newKey.append(upper);
                for (int i = endIndex; i < key.length(); i++) {
                    newKey.append(key.charAt(i));
                }

                System.out.println(newKey);
                return String.valueOf(newKey);
            }
            case "Lower" -> {
                String lower = "";
                for (int i = startIndex; i < endIndex; i++) {
                    lower += key.charAt(i);
                }
                lower = lower.toLowerCase();
                StringBuilder newKey = new StringBuilder();

                for (int i = 0; i < startIndex; i++) {
                    newKey.append(key.charAt(i));
                }
                newKey.append(lower);
                for (int i = endIndex; i < key.length(); i++) {
                    newKey.append(key.charAt(i));
                }

                System.out.println(newKey);
                return String.valueOf(newKey);
            }
        }
        return null;
    }

    public static String Slice(String key, int startIndex, int endIndex) {

        StringBuilder trimmed = new StringBuilder(key);
        trimmed.delete(startIndex, endIndex);

        System.out.println(trimmed);
        return String.valueOf(trimmed);
    }
}
