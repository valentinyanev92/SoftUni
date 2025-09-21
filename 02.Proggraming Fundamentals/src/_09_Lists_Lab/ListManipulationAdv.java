package _09_Lists_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inpt = scanner.nextLine();

        String[] inArr = inpt.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inArr.length; i++) {
            list.add(Integer.parseInt(inArr[i]));
        }

        String input = "";
        while (!input.equals("end")) {
            input = scanner.nextLine();
            String[] inputArr = input.split(" ");

            switch (inputArr[0]) {
                case "Contains":
                    contains(Integer.parseInt(inputArr[1]), list);
                    break;
                case "Print":
                    switch (inputArr[1]) {
                        case "even":
                            printEven(list);
                            break;
                        case "odd":
                            printOdd(list);
                            break;
                    }
                case "Get":
                    switch (inputArr[1]) {
                        case "sum":
                            getSum(list);
                            break;
                    }
                case "Filter":
                    switch (inputArr[1]) {
                        case ">":
                            filterBigger(Integer.parseInt(inputArr[2]), list);
                            break;
                        case "<":
                            filterSmaller(Integer.parseInt(inputArr[2]), list);
                            break;
                        case ">=":
                            filterBiggerOrEqual(Integer.parseInt(inputArr[2]), list);
                            break;
                        case "<=":
                            filterSmallerOrEqual(Integer.parseInt(inputArr[2]), list);
                            break;
                    }
                    break;

            }
        }
    }

    private static void filterSmallerOrEqual(int i, List<Integer> list) {
        for (int j = 0; j < list.size(); j++) {
            if(list.get(j) <= i){
                System.out.print(list.get(j)+" ");
            }
        }
        System.out.println();
    }

    private static void filterBiggerOrEqual(int i, List<Integer> list) {
        for (int j = 0; j < list.size(); j++) {
            if(list.get(j) >= i){
                System.out.print(list.get(j)+" ");
            }
        }
        System.out.println();
    }

    private static void filterSmaller(int i, List<Integer> list) {
        for (int j = 0; j < list.size(); j++) {
            if(list.get(j) < i){
                System.out.print(list.get(j)+" ");
            }
        }
        System.out.println();
    }

    private static void filterBigger(int i, List<Integer> list) {
        for (int j = 0; j < list.size(); j++) {
            if(list.get(j) > i){
                System.out.print(list.get(j)+" ");
            }
        }
        System.out.println();
    }

    private static void getSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }

    private static void printOdd(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 0) {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }

    private static void printEven(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }

    private static void contains(int i, List<Integer> list) {
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == i) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No such number");
    }
}
