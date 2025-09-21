package Exam_Preparation.E03_RestaurantApp_6April2024.models.working;

import Exam_Preparation.E03_RestaurantApp_6April2024.models.client.Client;
import Exam_Preparation.E03_RestaurantApp_6April2024.models.waiter.Waiter;

import java.util.Collection;

public class WorkingImpl implements Working {

    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {

        Collection<String> orders = client.getClientOrders();

        for (Waiter waiter : waiters) {
            while (waiter.canWork() && orders.iterator().hasNext()) {
                waiter.work();
                String currentOrder = orders.iterator().next();
                waiter.takenOrders().getOrdersList().add(currentOrder);
                orders.remove(currentOrder);
            }
        }
    }
}
