package _06_SetsAndMapsAdvanced_Exercises;

import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> handsOfCards = new LinkedHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(": ");

            if (input[0].equals("JOKER")) {
                break;
            }

            String player = input[0];
            String[] cards = input[1].split(", ");

            for (String card : cards) {
                handsOfCards.putIfAbsent(player, new TreeSet<>());
                handsOfCards.get(player).add(card);
            }
        }

        handsOfCards.forEach((player, hands) -> {
            int value = 0;
            for (String card : hands) {
                value += CheckCardValue(card);
            }
            System.out.println(player + ": " + value);
        });
    }

    private static int CheckCardValue(String card) {
        int value = 0;

        char currentCard = card.charAt(0);
        char currentColor = card.charAt(1);

        if (card.length() == 3) {
            currentColor = card.charAt(2);
            switch (currentColor) {
                case 'S' -> value = 4;
                case 'H' -> value = 3;
                case 'D' -> value = 2;
                case 'C' -> value = 1;
            }

        } else {
            switch (currentColor) {
                case 'S' -> value = 4;
                case 'H' -> value = 3;
                case 'D' -> value = 2;
                case 'C' -> value = 1;
            }
        }
        if (card.length() == 3) {
            value *= 10;
        } else {
            switch (currentCard) {
                case '2' -> value *= 2;
                case '3' -> value *= 3;
                case '4' -> value *= 4;
                case '5' -> value *= 5;
                case '6' -> value *= 6;
                case '7' -> value *= 7;
                case '8' -> value *= 8;
                case '9' -> value *= 9;
                case 'J' -> value *= 11;
                case 'Q' -> value *= 12;
                case 'K' -> value *= 13;
                case 'A' -> value *= 14;
            }
        }

        return value;
    }
}
