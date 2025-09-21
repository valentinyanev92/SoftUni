package _02_Abstraction_Exercise.P03_CardsWithPower;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cardValue = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        Suit suit = Suit.valueOf(cardSuit.toUpperCase());
        RankPower rankPower = RankPower.valueOf(cardValue.toUpperCase());
        Card card = new Card(suit, rankPower);

        System.out.println(card);
    }
}
