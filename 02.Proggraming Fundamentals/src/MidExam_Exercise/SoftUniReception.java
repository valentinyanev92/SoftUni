package MidExam_Exercise;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEfficient = Integer.parseInt(scanner.nextLine());
        int secondEfficient = Integer.parseInt(scanner.nextLine());
        int thirdEfficient = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int studentsPerHour = firstEfficient+secondEfficient+thirdEfficient;
        int hours = 0;
        while (studentsCount>0) {
            hours++;
            if(hours%4 != 0){
                studentsCount -= studentsPerHour;
            }
        }

        System.out.println("Time needed: " + hours + "h.");

    }
}
