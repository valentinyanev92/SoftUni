package _09_Lists_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputAsString = input.split(" ");

        List<Integer> inputList = new ArrayList<>();
        fillListFromStrToInteger(inputList, inputAsString);


        List<Integer> summed = new ArrayList<>();
        for (int i = 0; i < inputList.size() / 2; i++) {
            summed.add(inputList.get(i) + inputList.get(inputList.size() - 1 - i));
        }
        if (inputList.size() % 2 == 1) {
            summed.add(inputList.get(inputList.size() / 2));
        }

        printList(summed);

    }

    private static void fillListFromStrToInteger(List<Integer> inputList, String[] inputAsString) {
        for (int i = 0; i < inputAsString.length; i++) {
            inputList.add(Integer.parseInt(inputAsString[i]));
        }
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
