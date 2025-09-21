package _09_Lists_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] inputAsString = input.split(" ");
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < inputAsString.length; i++) {
            list.add(Double.parseDouble(inputAsString[i]));
        }


        sumAdjElements(list);

        printList(list);
    }


    private static void sumAdjElements(List<Double> list) {
        int index = 0;
        while (index < list.size()-1){
            if (list.get(index).equals(list.get(index+1))){
                list.set(index, list.get(index)+ list.get(index+1));
                list.remove(index+1);
                index = 0;
            }else {
                index++;
            }
        }

    }

    private static void printList(List<Double> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%.0f ",list.get(i));
        }
    }
}
