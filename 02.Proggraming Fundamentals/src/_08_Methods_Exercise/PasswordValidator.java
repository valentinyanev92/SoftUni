package _08_Methods_Exercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        boolean passwordLength = getPasswordLength(password);
        if (passwordLength == false) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean passwordConsist = passwordConsist(password);
        if (passwordConsist == false) {
            System.out.println("Password must consist only of letters and digits");
        }

        boolean passwordCheck = passwordCheckForDigits(password);
        if (passwordCheck == false) {
            System.out.println("Password must have at least 2 digits");
        }

        if (passwordCheck == true && passwordConsist == true && passwordLength == true) {
            System.out.println("Password is valid");
        }


    }


    private static boolean getPasswordLength(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean passwordConsist(String password) {
        boolean check = false;
        for (int i = 0; i < password.length(); i++) {
            char current = (char) password.charAt(i);
            if ((int) current >= 48 && (int) current <= 57
                    || (int) current >= 65 && (int) current <= 90
                    || (int) current >= 97 && (int) current <= 122) {
                check = true;
            }else{
                check=false;
                return check;
            }
        }
        return check;
    }

    private static boolean passwordCheckForDigits(String password) {
        char charAt;
        int digits = 0;
        for (int i = 0; i < password.length(); i++) {
            if ((int) password.charAt(i) >= 48 && (int) password.charAt(i) <= 57) {
                digits++;
            }
        }
        if (digits >= 2) {
            return true;
        } else {
            return false;
        }

    }
}
