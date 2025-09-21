package _09_FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> priceList = Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble).toList();

        UnaryOperator<Double> addVAT = x -> x * 1.2;

        System.out.println("Prices with VAT:");
        priceList.forEach(x -> {
            System.out.printf("%.2f%n", addVAT.apply(x));
        });

    }
}
