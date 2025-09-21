package _04_DataTypesAndVariables_MoreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split(" ");
            long left = Long.parseLong(input[0]);
            long right = Long.parseLong(input[1]);
            long bigger = Math.max(left, right);
            bigger = Math.abs(bigger);

            int sum = 0;
            while (bigger != 0) {
                sum += bigger % 10;
                bigger /= 10;
            }
            System.out.println(sum);
        }
    }
}
