package _04_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());
        int four = Integer.parseInt(scanner.nextLine());

        int result = (one + two)/three*four;
        System.out.println(result);
    }
}
