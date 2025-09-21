package _06_SetsAndMapsAdvanced_Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> symbols = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (!symbols.containsKey(symbol)) {
                symbols.put(symbol, 1);
            }else {
                symbols.put(symbol, symbols.get(symbol) + 1);
            }
        }

        symbols.forEach((key, value) -> {
            System.out.println(key + ": " + value + " time/s");
        });
    }
}
