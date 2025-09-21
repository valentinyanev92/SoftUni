package _04_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        int tankCapacity = 255;
        int litersInTank = 0;
        for (int i = 0; i < count; i++) {
            int current = Integer.parseInt(scanner.nextLine());
            if (current > tankCapacity) {
                System.out.println("Insufficient capacity!");
            } else {
                litersInTank += current;
                tankCapacity -= current;
            }
        }
        System.out.println(litersInTank);
    }
}
