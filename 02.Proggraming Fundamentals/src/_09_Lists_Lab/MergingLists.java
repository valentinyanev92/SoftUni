package _09_Lists_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFist = scanner.nextLine();
        String inputSecond = scanner.nextLine();

        String[] inputFirstArray = inputFist.split(" ");
        String[] inputSecondArray = inputSecond.split(" ");

        List<Integer> fistList = new ArrayList<>();
        for (int i = 0; i < inputFirstArray.length; i++) {
            fistList.add(Integer.parseInt(inputFirstArray[i]));
        }

        List<Integer> secondList = new ArrayList<>();
        for (int i = 0; i < inputSecondArray.length; i++) {
            secondList.add(Integer.parseInt(inputSecondArray[i]));
        }

        List<Integer> merged = merge(fistList, secondList);

        printList(merged);


    }

    private static List<Integer> merge(List<Integer> fistList, List<Integer> secondList) {
        List<Integer> longer = new ArrayList<>();
        List<Integer> shorter = new ArrayList<>();
        int check = 0;
        if (fistList.size() > secondList.size()) {
            longer = fistList;
            shorter = secondList;
            check = 1;
        } else {
            longer = secondList;
            shorter = fistList;
            check = 2;
        }

        List<Integer> merged = new ArrayList<>();
        for (int i = 0; i < longer.size(); i++) {
            if (i < shorter.size() ) {
                merged.add(fistList.get(i));
                merged.add(secondList.get(i));
            } else if (check == 1) {
                merged.add(fistList.get(i));
            } else if (check==2) {
                merged.add(secondList.get(i));
            }
        }
        return merged;
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
