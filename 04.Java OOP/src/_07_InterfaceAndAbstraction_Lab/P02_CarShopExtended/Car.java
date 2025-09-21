package _07_InterfaceAndAbstraction_Lab.P02_CarShopExtended;

public interface Car {
    Integer TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
