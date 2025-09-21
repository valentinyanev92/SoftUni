package _01_Abstractions_Lab.P04_HotelReservation;

public class PriceCalculator {

    public static double calculate(double pricePerDay, int days, Season season, Discount discount) {
        return(pricePerDay * days * season.getMultiplayer()) * discount.getDiscount();
    }

}
