package _10_Lists_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] firstSplit = input.split("\\|");

        List<Integer> secondSplit = new ArrayList<>();

        for (int i = firstSplit.length - 1; i >= 0; i++) {
            String[] midSplit = firstSplit[i].split("\\s++");
            for (int j = 0; j < midSplit.length; j++) {
                if(midSplit[j].isEmpty()){

                }else {
                secondSplit.add(Integer.parseInt(midSplit[j]));}
            }
            i=firstSplit.length-1;
        }

        for (int i = 0; i < secondSplit.size(); i++) {
            System.out.println(secondSplit.get(i)+" ");
        }
    }
}
