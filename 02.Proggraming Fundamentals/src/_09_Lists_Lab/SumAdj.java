package _09_Lists_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputAsArray = input.split(" ");

        List<Integer> listInput = new ArrayList<>();
        for (int i = 0; i < inputAsArray.length; i++) {
            listInput.add(Integer.parseInt(inputAsArray[i]));
        }

        List<Integer> summedInput = new ArrayList<>();

        summedInput = getSum(listInput);
        printList(summedInput);


    }

    private static List<Integer> getSum(List<Integer> listInput) {
        List<Integer> summed = new ArrayList<>();
        for (int i = 0; i < listInput.size()-1; i++) {
            if (listInput.get(i)==listInput.get(i+1)){
                summed.add(listInput.get(i)+listInput.get(i+1));
                i++;
            }else {
                summed.add(listInput.get(i));
            }
            if (listInput.size()-2==i){
                summed.add(listInput.get(listInput.size()-1));
            }
        }
        for (int i = 0; i < summed.size()-1; i++) {
            if (summed.get(i) == summed.get(i+1)){
                summed.set(i, summed.get(i)+ summed.get(i+1));
                summed.remove(i+1);
                i = -1;
            }
        }
        return summed;
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
