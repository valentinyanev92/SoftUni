package _03_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pounds = Double.parseDouble(scanner.nextLine());;
        double poundsInCents = pounds*100;
        double dollars =poundsInCents*1.36 ;
        System.out.printf("%.3f", dollars/100);
    }
}
