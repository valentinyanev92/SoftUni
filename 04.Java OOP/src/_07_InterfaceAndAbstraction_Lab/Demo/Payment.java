package _07_InterfaceAndAbstraction_Lab.Demo;

public class Payment implements Payable {



    @Override
    public boolean payWithCard(double cost, double cardBalance) {
        if (cost <= cardBalance && cost >= MIN) {
            return true;
        }else {
            return false;
        }
    }
}
