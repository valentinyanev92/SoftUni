package _11_ObjectsAndClasses_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String[] input = in.split(" ");
        List<String> inp = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            inp.add(input[i]);
        }
        Random ran = new Random();
        for (int i = 0; i < inp.size(); i++) {
            int random = ran.nextInt(inp.size()-i);
            System.out.println(inp.get(i));

        }
    }
}
