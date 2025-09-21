package _10_Lists_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String[] inArr = in.split(" ");

        List<Integer> field = new ArrayList<>();
        for (int i = 0; i < inArr.length; i++) {
            field.add(Integer.parseInt(inArr[i]));
        }

        int bombPlace = scanner.nextInt();
        int bombPower = scanner.nextInt();
        List<Integer> bombed = new ArrayList<>();

        detonateBomb(field, bombPlace, bombPower, bombed);

        for (int i = 0; i < bombed.size(); i++) {
            if(bombed.get(i)==bombPlace){
                List<Integer> newBombed = new ArrayList<>();
                detonateBomb(bombed, bombPlace, bombPower, newBombed);
                bombed=newBombed;
            }
        }


        int sum = 0;
        for (int i = 0; i < bombed.size(); i++) {
            sum += bombed.get(i);
        }
        System.out.println(sum);

    }

    private static void detonateBomb(List<Integer> field, int bombPlace, int bombPower, List<Integer> bombed) {
        for (int i = 0; i < field.size(); i++) {
            if (field.get(i) == bombPlace) {
                for (int j = 0; j < i - bombPower; j++) {
                    bombed.add(field.get(j));
                }
                for (int j = i + bombPower + 1; j < field.size(); j++) {
                    bombed.add(field.get(j));
                }
                break;
            }
        }
    }
}
