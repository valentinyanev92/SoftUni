package Exam_Preparation.E03_RestaurantApp_6April2024.models.orders;


import java.util.ArrayList;
import java.util.Collection;

public class TakenOrdersImpl implements TakenOrders {

    private Collection<String> orderList;

    public TakenOrdersImpl() {
        this.orderList = new ArrayList<>();
    }

    @Override
    public Collection<String> getOrdersList() {
        return orderList;
    }
}
