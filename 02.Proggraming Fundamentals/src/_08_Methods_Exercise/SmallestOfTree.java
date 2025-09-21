package _08_Methods_Exercise;

import java.util.Scanner;

public class SmallestOfTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int smallest = getSmallestOfTree(first, second, third);
        System.out.println(smallest);
    }

    private static int getSmallestOfTree(int first, int second, int third) {
        first = getSmallestOftwo(first, second);
        first = getSmallestOftwo(first, third);
        return first;
    }

    private static int getSmallestOftwo(int first, int second){
        if (first > second){
            return second;
        }else {
            return first;
        }

    }
}
