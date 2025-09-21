package _04_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class PrintPartOfTheASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int begin = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int i = begin; i <= end; i++) {
            char current = (char) i;
            System.out.print(current + " ");
        }
    }
}
