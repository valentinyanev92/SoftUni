package _01_BasicSyntaxConditionalStatementsAndLoops_Lab;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        if (age<0 || age >122){
            System.out.println("Error!");
            return;
        }

        int ticketPrice = 0;
        if (day.equals("Weekday")){
            if (age <= 18){
                ticketPrice = 12;
            }
            if (age >18 && age <=64){
                ticketPrice = 18;
            }
            if (age >64){
                ticketPrice = 12;
            }
        } else if (day.equals("Weekend")) {
            if (age <= 18){
                ticketPrice = 15;
            }
            if (age >18 && age <=64){
                ticketPrice = 20;
            }
            if (age >64){
                ticketPrice = 15;
            }
        } else if (day.equals("Holiday")) {
            if (age <= 18){
                ticketPrice = 5;
            }
            if (age >18 && age <=64){
                ticketPrice = 12;
            }
            if (age >64){
                ticketPrice = 10;
            }
        }

        System.out.println(ticketPrice+"$");
    }
}
