package org.example.productshop.repositories;

import org.example.productshop.entities.Product;
import org.example.productshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> getByPriceBetweenAndBuyerOrderByPriceAsc(BigDecimal priceAfter, BigDecimal priceBefore, User buyer);
}
