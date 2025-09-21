package _07_InterfaceAndAbstraction_Lab.P01_CarShop;

public interface Car {
    Integer TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
