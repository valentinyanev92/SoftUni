package Exam_Preparation.E03_RestaurantApp_6April2024.models.client;

import java.util.ArrayList;
import java.util.Collection;

import static Exam_Preparation.E03_RestaurantApp_6April2024.common.ExceptionMessages.CLIENT_NAME_NULL_OR_EMPTY;

public class ClientImpl implements Client {

    private String name;
    private Collection<String> orders;

    public ClientImpl(String name) {
        this.setName(name);
        this.orders = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(CLIENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getClientOrders() {
        return orders;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
