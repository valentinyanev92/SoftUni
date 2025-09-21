package _01_BasicSyntaxConditionalStatementsAndLoops_Lab;

import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  country = scanner.nextLine();

        switch (country){
            case "USA", "England":
                System.out.println("English");
                break;
            case "Spain", "Argentina", "Mexico":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}
