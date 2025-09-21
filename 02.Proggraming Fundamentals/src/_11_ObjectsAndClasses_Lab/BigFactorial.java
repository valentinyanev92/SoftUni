package _11_ObjectsAndClasses_Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        BigInteger first = new BigInteger("1");

        for (int i = 1; i <= number; i++) {
            first = first.multiply(BigInteger.valueOf(i));
        }
        System.out.println(first);


    }
}
