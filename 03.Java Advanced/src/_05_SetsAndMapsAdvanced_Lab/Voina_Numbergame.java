package _05_SetsAndMapsAdvanced_Lab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Voina_Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = readNumbers(scanner);
        Set<Integer> secondPlayer = readNumbers(scanner);

        int rounds = 0;
        while (rounds < 50 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            int firstCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstCard);

            int secondCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            } else if (secondCard > firstCard) {
                secondPlayer.add(secondCard);
                secondPlayer.add(firstCard);
            } else {
                firstPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }

            rounds++;
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static Set<Integer> readNumbers(Scanner scanner) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(scanner.nextInt());
        }
        return set;
    }
}

