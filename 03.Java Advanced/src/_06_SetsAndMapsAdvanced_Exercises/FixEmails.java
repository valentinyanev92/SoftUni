package _06_SetsAndMapsAdvanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();
        while (true) {
            String name = scanner.nextLine();
            if (name.equals("stop")) {
                break;
            }

            String email = scanner.nextLine().trim();

            if (!isInvalidDomain(email)) {
                emails.put(name, email);
            }
        }

        emails.forEach((name, email) -> {
            System.out.println(name + " -> " + email);
        });
    }

    private static boolean isInvalidDomain(String email) {
        if (email == null || email.isEmpty()) {
            return true;
        }

        String lowerCaseEmail = email.toLowerCase();
        return lowerCaseEmail.endsWith(".us") || lowerCaseEmail.endsWith(".uk") || lowerCaseEmail.endsWith(".com");
    }
}
