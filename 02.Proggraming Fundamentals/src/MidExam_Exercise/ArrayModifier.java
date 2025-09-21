package MidExam_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String array = scanner.nextLine();
        String[] arrayArr = array.split(" ");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrayArr.length; i++) {
            list.add(Integer.parseInt(arrayArr[i]));
        }

        String input = "";
        while (!input.equals("end")) {
            input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            switch (inputArr[0]) {
                case "swap":
                    swap(list, Integer.parseInt(inputArr[1]), Integer.parseInt(inputArr[2]));
                    break;
                case "multiply":
                    multiply(list, Integer.parseInt(inputArr[1]), Integer.parseInt(inputArr[2]));
                    break;
                case "decrease":
                    decrease(list);
                    break;

            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }
    }

    private static void decrease(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) - 1);
        }
    }

    private static void multiply(List<Integer> list, int i, int i1) {
        int set = list.get(i) * list.get(i1);
        list.set(i, set);
    }

    private static void swap(List<Integer> list, int i, int i1) {
        int temp = list.get(i);
        list.set(i, list.get(i1));
        list.set(i1, temp);
    }
}
