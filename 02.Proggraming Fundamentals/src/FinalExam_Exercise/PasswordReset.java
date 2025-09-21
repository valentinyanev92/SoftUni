package FinalExam_Exercise;

import java.util.Scanner;

public class PasswordReset {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        boolean isOver = true;
        while (isOver) {

            String[] action = scanner.nextLine().split(" ");
            switch (action[0]) {
                case "TakeOdd" -> {
                    password = TakeOdd(password);
                    System.out.println(password);
                }
                case "Cut" -> {
                    password = Cut(password, Integer.parseInt(action[1]), Integer.parseInt(action[2]));
                    System.out.println(password);
                }
                case "Substitute" -> {
                    password = Substitute(password, action[1], action[2]);
                }
                case "Done" -> isOver = false;
            }
        }
        System.out.println("Your password is: " + password);
    }

    public static String TakeOdd(String password) {

        StringBuilder newPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if (i % 2 == 1) {
                newPassword.append(password.charAt(i));
            }
        }

        return String.valueOf(newPassword);
    }

    public static String Cut(String password, int index, int length) {

        StringBuilder pass = new StringBuilder(password);
        for (int i = 0; i < length; i++) {
            pass.deleteCharAt(index);
        }
        return String.valueOf(pass);
    }

    public static String Substitute(String password, String substring, String substitute) {

        if (password.contains(substring)) {
            password = password.replace(substring, substitute);
            System.out.println(password);
        } else {
            System.out.println("Nothing to replace!");
        }
        return password;
    }
}