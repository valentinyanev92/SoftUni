package _02_Abstraction_Exercise.P02_CardRank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String rank = input.nextLine();
        System.out.println(rank + ":");

        for (int i = 0; i < CardRanks.values().length; i++) {
            CardRanks cardRank = CardRanks.values()[i];
            System.out.println(cardRank.toString());
        }

    }
}
