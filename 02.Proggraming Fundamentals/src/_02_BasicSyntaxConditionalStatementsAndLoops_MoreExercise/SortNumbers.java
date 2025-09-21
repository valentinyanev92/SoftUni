package _02_BasicSyntaxConditionalStatementsAndLoops_MoreExercise;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= 2; i++) {
            if (three > two) {
                int mid = two;
                two = three;
                three = mid;
            }
            if (two > one) {
                int mid = one;
                one = two;
                two = mid;

            }
        }
        System.out.printf("%d%n%d%n%d%n", one, two, three);
    }
}
