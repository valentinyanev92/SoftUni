package MidExam_Official;

import java.util.*;

public class MagicCards {
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
                    if (deck.contains(input[1]) && Integer.parseInt(input[2]) < newDeck.size() && Integer.parseInt(input[2]) >= 0) {
                            newDeck.add(Integer.parseInt(input[2]), input[1]);
                    } else {
                        System.out.println("Error!");
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
                    String firstCard = input[1];
                    String secondCard = input[2];
                    int firstIndex = newDeck.indexOf(firstCard);
                    int secondIndex = newDeck.indexOf(secondCard);
                    Collections.swap(newDeck, firstIndex, secondIndex);
                    break;

                case "Shuffle":
                    if (input[1].equals("deck")) {
                        Collections.reverse(newDeck);
                      }
                    break;
            }

        }
        for (String s : newDeck) {
            System.out.print(s + " ");
        }

    }
}
