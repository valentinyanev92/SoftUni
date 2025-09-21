package MidExam_Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");

        List<Integer> line = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            line.add(Integer.parseInt(inputArr[i]));
        }

        if (line.size() == 1) {
            System.out.println("No");
            return;
        }

        double average = 0;
        for (int i = 0; i < line.size(); i++) {
            average += line.get(i);
        }
        average /= line.size();

        List<Integer> listAboveAverage = new ArrayList<>();
        for (int i = 0; i < line.size(); i++) {
            if(line.get(i)>average){
                listAboveAverage.add(line.get(i));
            }
        }
        listAboveAverage.sort(Collections.reverseOrder());

        if(listAboveAverage.isEmpty()){
            System.out.println("No");
        }else {
            for (int i = 0; i < Math.min(5, listAboveAverage.size()); i++) {
                System.out.print(listAboveAverage.get(i)+" ");
            }
        }
    }
}
