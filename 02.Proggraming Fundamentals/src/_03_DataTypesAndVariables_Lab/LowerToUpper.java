package _03_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class LowerToUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char in = scanner.next().charAt(0);
        if (in <= (char) 96){
            System.out.println("upper-case");
        }else{
            System.out.println("lower-case");
        }
    }
}
