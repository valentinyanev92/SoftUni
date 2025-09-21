package _02_Abstraction_Exercise.P02_CardRank;

public enum CardRanks {
    ACE(0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7),
    NINE(8),
    TEN(9),
    JACK(10),
    QUEEN(11),
    KING(12);

    private int rank;

    CardRanks(int rank) {
        this.rank = rank;
    }


    public int getName() {
        return this.getName();
    }

    @Override
    public String toString() {
        return "Ordinal value: " + this.rank + "; Name value: " + this.name();
    }
}
