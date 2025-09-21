package _02_Abstraction_Exercise.P03_CardsWithPower;

public class Card {

    private Suit suit;
    private RankPower rank;

    public Card(Suit suit, RankPower rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card name: " + Enum.valueOf(RankPower.class, rank.name()) + " of " +
                Enum.valueOf(Suit.class, suit.name()) + "; Card power: " +
                (rank.getPower() + suit.getValue());
    }
}
