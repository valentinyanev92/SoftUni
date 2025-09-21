package _01_Abstractions_Lab.P04_HotelReservation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        System.out.printf("%.2f", PriceCalculator.calculate(Double.parseDouble(input[0]),
                Integer.parseInt(input[1]), Season.valueOf(input[2]), Discount.valueOf(input[3])));

    }
}
