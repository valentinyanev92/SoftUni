package _04_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kegs = Integer.parseInt(scanner.nextLine());

        String biggestKeg = "";
        double biggestCapacity = 0;
        for (int i = 0; i < kegs; i++) {
            String currentKeg = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double capacity = Math.PI * radius * radius * height;
            if (capacity>biggestCapacity){
                biggestKeg = currentKeg;
                biggestCapacity = capacity;
            }
        }
        System.out.println(biggestKeg);
    }
}
