package _03_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int centuries = Integer.parseInt(scanner.nextLine());
        double year = centuries * 100;
        double days = year * 365.2422;
        double hours = days * 24;
        double minutes = hours * 60;
        System.out.printf("%d centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes",
                centuries, year, days, hours, minutes);
    }
}
