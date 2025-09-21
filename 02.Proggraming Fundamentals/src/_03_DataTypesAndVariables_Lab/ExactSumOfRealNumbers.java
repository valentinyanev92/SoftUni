package _03_DataTypesAndVariables_Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(0);
        for (int n = 0; n < numbers; n++) {
            BigDecimal num = new BigDecimal(scanner.nextLine());
            sum = sum.add(num);
        }
        System.out.println(sum);
    }
}
