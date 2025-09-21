package _07_InterfaceAndAbstraction_Lab.Demo;

public interface Payable {

    int MIN = 5;

    boolean payWithCard(double cost, double cardBalance);
}
