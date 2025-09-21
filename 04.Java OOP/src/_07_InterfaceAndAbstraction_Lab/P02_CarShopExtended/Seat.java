package _07_InterfaceAndAbstraction_Lab.P02_CarShopExtended;

public class Seat extends CarImpl implements Sellable{
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }


    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nLeon sells for %f", this.getPrice());
    }
}
