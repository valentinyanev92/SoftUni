package _09_Lists_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationBasic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inList = scanner.nextLine();

        String[] inArray = inList.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inArray.length; i++) {
            list.add(Integer.parseInt(inArray[i]));
        }

        String input = "";
        while (!input.equals("end")) {
            input = scanner.nextLine();
            String[] in = input.split(" ");
            switch (in[0]) {
                case "Add":
                    list.add(Integer.parseInt(in[1]));
                    break;
                case "Remove":
                    Integer remove = Integer.parseInt(in[1]);
                    list.remove(remove);
                    break;
                case "RemoveAt":
                    list.remove(Integer.parseInt(in[1]));
                    break;
                case "Insert":
                    list.add(Integer.parseInt(in[2]), Integer.parseInt(in[1]));
                    break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
