package _07_Methods_Lab;

import java.util.Scanner;

public class CalculateRectrangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        int area = getArea(width, length);
        System.out.println(area);

    }

    private static int getArea(int width, int length) {
        int area = width*length;
        return area;
    }
}
