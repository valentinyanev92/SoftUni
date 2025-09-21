package _14_AssociativeArrays_MapsLambdaAndStreamAPI_Exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        HashMap<Character, Integer> charsCount = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                char current = input[i].charAt(j);
                charsCount.putIfAbsent(current, 0);
                charsCount.replace(current, charsCount.get(current)+1);
            }
        }

        charsCount.forEach((character, integer) -> {
            System.out.println(character + " -> " + integer);
        });
    }
}
