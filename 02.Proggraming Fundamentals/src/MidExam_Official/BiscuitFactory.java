package MidExam_Official;

import java.util.Scanner;

public class BiscuitFactory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int biscuitPerDay = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int comparingBiscuit = Integer.parseInt(scanner.nextLine());

        int totalBiscuit = 0;
        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0) {
                double current = Math.floor(biscuitPerDay * workers * 0.75);
                totalBiscuit += (int) current;
            } else {
                totalBiscuit += biscuitPerDay * workers;
            }
        }
        System.out.println("You have produced " + totalBiscuit + " biscuits for the past month.");

        if (totalBiscuit > comparingBiscuit) {
            int difference = totalBiscuit - comparingBiscuit;
            double percentDifference = (double) difference / comparingBiscuit * 100;
            System.out.printf("You produce %.2f percent more biscuits.", percentDifference);
        } else {
            int difference = comparingBiscuit - totalBiscuit;
            double percentDifference = (double) difference / comparingBiscuit * 100;
            System.out.printf("You produce %.2f percent less biscuits.", percentDifference);
        }

    }
}
