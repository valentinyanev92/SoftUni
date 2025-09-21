package _02_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        String password = "";

        for (int i = userName.length()-1; i >=0; i--) {
            char current = userName.charAt(i);
            password += current;
        }

        int tries = 0;
        while (true){
            String input = scanner.nextLine();
            if (input.equals(password)){
                System.out.printf("User %s logged in.",userName);
                break;
            }
            tries ++;
            if (tries == 4){
                System.out.printf("User %s blocked!",userName);
                break;
            }else {
                System.out.println("Incorrect password. Try again.");

            }
        }
    }
}
