package MidExam_Official;

import java.util.Scanner;

public class SpringVacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int peoples = Integer.parseInt(scanner.nextLine());
        double fuelPricePerDay = Double.parseDouble(scanner.nextLine());
        double foodPerDay = Double.parseDouble(scanner.nextLine());
        double roomPricePerDay = Double.parseDouble(scanner.nextLine());

        double moneySpend = 0;
        if (peoples <= 10) {
            moneySpend = (foodPerDay * peoples) * days + (roomPricePerDay * peoples) * days;

        } else {
            moneySpend = (foodPerDay * peoples) * days + (roomPricePerDay * 0.75) * peoples * days;
        }

        for (int i = 1; i <= days; i++) {
            double traveledDistance = Double.parseDouble(scanner.nextLine());

            double currentSpending = traveledDistance * fuelPricePerDay;
            moneySpend += currentSpending;

            if (i % 3 == 0 || i % 5 == 0) {
                moneySpend *= 1.4;
            }

            if (i % 7 == 0) {
                double moneyBonus = moneySpend / peoples;
                moneySpend -= moneyBonus;
            }
            if (moneySpend > budget) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", moneySpend - budget);
                return;
            }

        }

        System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - moneySpend);

    }
}
