package _08_Methods_Exercise;

import java.util.Scanner;

public class AddAndSubstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());

        int add = sum(one, two);
        int subs = substract(add, three);

        System.out.println(subs);
    }

    public static int sum(int one, int two){
        int sum = one + two;
        return sum;
    }

    public static int substract(int add, int three){
        int subs = add - three;
        return subs;
    }
}
