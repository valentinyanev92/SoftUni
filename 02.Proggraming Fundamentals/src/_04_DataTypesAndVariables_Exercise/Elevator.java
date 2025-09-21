package _04_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleNumber = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        int courses = peopleNumber/elevatorCapacity;
        if (peopleNumber%elevatorCapacity!= 0){
            courses++;
        }
        System.out.println(courses);
    }
}
