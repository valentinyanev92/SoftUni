package _02_Abstraction_Exercise.P01_CardSuit;

public enum Suits {
    CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);

    private int value;

    Suits(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Ordinal value: " + this.value + "; Name value: " + this.name();
    }
}
