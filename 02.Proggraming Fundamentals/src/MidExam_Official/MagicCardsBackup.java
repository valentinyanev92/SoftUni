package MidExam_Official;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MagicCardsBackup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> deck = new ArrayList<>(Arrays.stream(scanner.nextLine().split(":")).toList());

        List<String> newDeck = new ArrayList<>();
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Ready")) {
                break;
            }

            switch (input[0]) {
                case "Add":
                    if (deck.contains(input[1])) {
                        newDeck.add(input[1]);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    if (deck.contains(input[1])) {
                        if (Integer.parseInt(input[2]) < newDeck.size() ){
                            newDeck.add(Integer.parseInt(input[2]), input[1]);
                        } else {
                            System.out.println("Error");
                            break;
                        }
                    } else {
                        System.out.println("Error!");
                        break;
                    }
                    break;
                case "Remove":
                    if (newDeck.contains(input[1])) {
                        int index = newDeck.indexOf(input[1]);
                        newDeck.remove(index);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String temp = input[1];
                    int firstIndex = newDeck.indexOf(input[1]);
                    int secondIndex = newDeck.indexOf(input[2]);
                    newDeck.set(firstIndex, newDeck.get(secondIndex));
                    newDeck.set(secondIndex, temp);
                    break;
                case "Shuffle":
                    if (input[1].equals("deck")) {
                        for (int i = 0; i < newDeck.size()/2; i++) {
                            String tempShuffle = newDeck.get(i);
                            newDeck.set(i, newDeck.get(newDeck.size()-i-1));
                            newDeck.set(newDeck.size()-i-1, tempShuffle);
                        }
                    }
                    break;
            }

        }
        for (String s : newDeck) {
            System.out.print(s + " ");
        }

    }
}
