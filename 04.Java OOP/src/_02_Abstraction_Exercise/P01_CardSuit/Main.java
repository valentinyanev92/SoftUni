package _02_Abstraction_Exercise.P01_CardSuit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("Card Suits:");
        System.out.println(Suits.CLUBS.toString());
        System.out.println(Suits.DIAMONDS.toString());
        System.out.println(Suits.HEARTS.toString());
        System.out.println(Suits.SPADES.toString());

    }
}
