package _01_Abstractions_Lab.P04_HotelReservation;

public enum Season {
    Spring(2),
    Summer(4),
    Autumn(1),
    Winter(3);

    private int multiplayer;

    Season(int multiplayer) {
        this.multiplayer = multiplayer;
    }

    public int getMultiplayer() {
        return multiplayer;
    }
}
