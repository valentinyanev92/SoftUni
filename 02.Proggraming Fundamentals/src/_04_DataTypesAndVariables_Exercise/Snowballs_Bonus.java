package _04_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class Snowballs_Bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        double maxSnowballValue = Double.NEGATIVE_INFINITY;
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;

        for (int i = 0; i < N; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow((double) snowballSnow / snowballTime, snowballQuality);

            if (snowballValue > maxSnowballValue) {
                maxSnowballValue = snowballValue;
                bestSnowballSnow = snowballSnow;
                bestSnowballTime = snowballTime;
                bestSnowballQuality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)%n", bestSnowballSnow, bestSnowballTime, maxSnowballValue, bestSnowballQuality);
    }
}
