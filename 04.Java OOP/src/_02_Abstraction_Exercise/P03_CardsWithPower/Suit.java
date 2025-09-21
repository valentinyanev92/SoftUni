package _02_Abstraction_Exercise.P03_CardsWithPower;

public enum Suit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
