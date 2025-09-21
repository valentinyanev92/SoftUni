package _01_BasicSyntaxConditionalStatementsAndLoops_Lab;

import java.util.Scanner;

public class TimeAfter30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        int totalInMin = hour * 60 + min + 30;
        if (totalInMin >= 1440) {
            totalInMin -= 1440;
        }
        hour = totalInMin / 60;
        min = totalInMin % 60;
        if (min<=9) {
            System.out.printf("%d:0%d", hour, min);
        } else {
            System.out.printf("%d:%d", hour, min);
        }
    }
}
