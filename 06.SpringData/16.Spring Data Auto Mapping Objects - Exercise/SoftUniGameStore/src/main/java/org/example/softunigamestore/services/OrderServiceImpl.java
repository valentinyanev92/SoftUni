package org.example.softunigamestore.services;

import jakarta.transaction.Transactional;
import org.example.softunigamestore.dtos.OrderInputDto;
import org.example.softunigamestore.entities.Order;
import org.example.softunigamestore.entities.OrderItem;
import org.example.softunigamestore.entities.ShoppingCart;
import org.example.softunigamestore.entities.User;
import org.example.softunigamestore.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, ShoppingCartService shoppingCartService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    @Transactional
    public void create(OrderInputDto dto) {
        User user = this.userService.getById(dto.getId());

        List<ShoppingCart> shoppingCartList = this.shoppingCartService.getForUser(dto.getId());
        if (shoppingCartList.isEmpty()) throw new IllegalArgumentException("No items in shopping cart found!");

        Order order = new Order();
        order.setUser(user);
        order.setTime(LocalDateTime.now());

        Set<OrderItem> orderItems = new HashSet<>();
        for (ShoppingCart item : shoppingCartList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setGame(item.getGame());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getGame().getPrice());

            orderItems.add(orderItem);
        }
        order.setItems(orderItems);

        this.orderRepository.save(order);
        this.shoppingCartService.clearForUser(user.getId());
    }
}
