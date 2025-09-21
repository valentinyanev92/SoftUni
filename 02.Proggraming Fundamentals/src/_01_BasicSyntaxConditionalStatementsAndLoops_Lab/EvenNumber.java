package _01_BasicSyntaxConditionalStatementsAndLoops_Lab;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Math.abs(Integer.parseInt(scanner.nextLine()));
        while (true){
            if (number%2==1 || number==0){
                System.out.println("Please write an even number.");
                number = Math.abs(Integer.parseInt(scanner.nextLine()));
            }else if (number%2==0){
                System.out.println("The number is: "+number);
                break;
            }
        }
    }
}
