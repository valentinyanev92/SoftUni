package _05_Arrays_Lab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int input = Integer.parseInt(scanner.nextLine());
        if (input <=0 || input >= 8){
            System.out.println("Invalid day!");
        }else {
            System.out.println(days[input-1]);
        }
    }
}
