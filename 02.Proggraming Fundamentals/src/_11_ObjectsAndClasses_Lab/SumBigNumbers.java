package _11_ObjectsAndClasses_Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();

        BigInteger first = new BigInteger(String.valueOf(firstNumber));
        BigInteger second = new BigInteger(String.valueOf(secondNumber));

        System.out.println(first.add(second));
    }
}
