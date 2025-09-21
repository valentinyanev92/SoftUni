package _04_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class SpiceMustFlow_Bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldCapacity = Integer.parseInt(scanner.nextLine());

        int days = 0;
        int spicesHold = 0;
        while (true) {
            if (fieldCapacity < 100) {
                if (spicesHold <= 26) {
                    spicesHold = 0;
                } else {
                    spicesHold -= 26;
                }
                break;
            }
            spicesHold += fieldCapacity;
            fieldCapacity -= 10;
            spicesHold -= 26;
            days++;
        }
        System.out.println(days);
        System.out.println(spicesHold);
    }
}
