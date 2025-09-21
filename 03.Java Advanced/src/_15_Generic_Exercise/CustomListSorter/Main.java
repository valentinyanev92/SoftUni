package _15_Generic_Exercise.CustomListSorter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CustomList<String> customList = new CustomList<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (!(command = scanner.nextLine()).equals("END")) {
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "Add":
                    customList.add(parts[1]);
                    break;
                case "Remove":
                    int index = Integer.parseInt(parts[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    System.out.println(customList.contains(parts[1]));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(parts[1]);
                    int index2 = Integer.parseInt(parts[2]);
                    customList.swap(index1, index2);
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(parts[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
                case "Sort":
                    sorter.sort(customList);
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}
