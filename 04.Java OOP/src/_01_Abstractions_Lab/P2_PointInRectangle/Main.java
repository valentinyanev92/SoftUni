package _01_Abstractions_Lab.P2_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Point bottomLeftPoint = new Point(coordinates[0], coordinates[1]);
        Point topLeftPoint = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(topLeftPoint, bottomLeftPoint);

        int checks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < checks; i++) {
            String[] current = scanner.nextLine().split(" ");
            int x = Integer.parseInt(current[0]);
            int y = Integer.parseInt(current[1]);

            Point checkPoint = new Point(x, y);
            System.out.println(rectangle.contains(checkPoint));
        }

    }
}
