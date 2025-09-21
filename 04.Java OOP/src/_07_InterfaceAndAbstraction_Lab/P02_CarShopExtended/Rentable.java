package _07_InterfaceAndAbstraction_Lab.P02_CarShopExtended;

public interface Rentable extends Car{

    Integer getMinRentDay();
    Double getPricePerDay();
}
