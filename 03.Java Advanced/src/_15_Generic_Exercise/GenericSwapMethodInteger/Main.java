package _15_Generic_Exercise.GenericSwapMethodInteger;

import _15_Generic_Exercise.GenericSwapMethodString.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            boxes.add(new Box(number));
        }

        String[] command = scanner.nextLine().split(" ");
        Box temp = boxes.get(Integer.parseInt(command[0]));
        boxes.set(Integer.parseInt(command[0]), boxes.get(Integer.parseInt(command[1])));
        boxes.set(Integer.parseInt(command[1]), temp);

        boxes.forEach(box -> {
            System.out.println(box.toString());
        });
    }
}
