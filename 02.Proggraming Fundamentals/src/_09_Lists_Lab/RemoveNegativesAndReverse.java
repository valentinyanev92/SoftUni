package _09_Lists_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            list.add(Integer.parseInt(inputArr[i]));
        }

        removeNegative(list);
        if(list.size()==0){
            System.out.println("empty");
        }else {
            printList(list.reversed());
        }
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    private static void removeNegative(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)<0){
                list.remove(i);
                i=-1;
            }
        }
    }
}
