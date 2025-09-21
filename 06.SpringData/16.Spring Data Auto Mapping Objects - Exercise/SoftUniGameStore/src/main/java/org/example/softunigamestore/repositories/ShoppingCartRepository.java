package org.example.softunigamestore.repositories;

import org.example.softunigamestore.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    List<ShoppingCart> findAllByUserId(long userId);
    void removeAllByUserId(long userId);
}
