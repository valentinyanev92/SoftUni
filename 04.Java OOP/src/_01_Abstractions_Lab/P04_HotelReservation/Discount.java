package _01_Abstractions_Lab.P04_HotelReservation;

public enum Discount {
    VIP(0.8),
    SecondVisit(0.9),
    None(1);

    private double discount;

    Discount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return this.discount;
    }
}
