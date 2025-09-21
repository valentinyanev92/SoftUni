package _10_Lists_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstIn = scanner.nextLine();
        String[] firstInArr = firstIn.split(" ");

        List<Integer> wagons = new ArrayList<>();
        for (int i = 0; i < firstInArr.length; i++) {
            wagons.add(Integer.parseInt(firstInArr[i]));
        }

        int capacity = Integer.parseInt(scanner.nextLine());

        String input = "";
        while (!input.equals("end")){
            input = scanner.nextLine();
            String[] inputArr = input.split(" ");

            switch (inputArr[0]){
                case "end":
                    break;
                case "Add":
                    wagons.add(Integer.parseInt(inputArr[1]));
                    break;
                default:
                    int add = Integer.parseInt(inputArr[0]);
                    addInList(add, capacity, wagons);
                    break;
            }
        }

        printList(wagons);

    }

    private static void printList(List<Integer> wagons) {
                    for (int i = 0; i < wagons.size(); i++) {
                System.out.print(wagons.get(i) + " ");

        }
    }

    private static void addInList(int add, int capacity, List<Integer> wagons) {
        for (int i = 0; i < wagons.size(); i++) {
            if (wagons.get(i) < capacity){
                if (wagons.get(i)+add <= capacity){
                    wagons.set(i, wagons.get(i)+add);
                    return;
                }
                if (wagons.get(i)<=add) {
                    for (int j = 0; j < wagons.size(); j++) {
                        if(wagons.get(j)+add<=capacity){
                            wagons.set(j, wagons.get(j)+add);
                            return;
                        }
                    }
                } else {
                    int diff=capacity-wagons.get(i);
                    int left=add - diff;
                    wagons.set(i, wagons.get(i)+diff);
                    if(wagons.size()-1==i){
                        wagons.add(left);
                        return;
                    }else {
                        while (left >0){
                            for (int j = i+1; j < wagons.size(); j++) {
                                if (wagons.get(j)+left<=capacity){
                                    wagons.set(j, wagons.get(j)+left);
                                    return;
                                }
                                else {
                                    diff = capacity - wagons.get(j);
                                    left = add - diff;
                                    wagons.set(j, wagons.get(j)+diff);
                                }
                            }
                            left = 0;
                        }
                    }
                }
            }
        }
    }


}
