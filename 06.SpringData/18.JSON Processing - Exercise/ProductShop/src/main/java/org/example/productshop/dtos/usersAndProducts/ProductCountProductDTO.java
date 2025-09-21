package org.example.productshop.dtos.usersAndProducts;

import org.example.productshop.entities.Product;

import java.math.BigDecimal;

public class ProductCountProductDTO {

    private String name;
    private BigDecimal price;

    public ProductCountProductDTO() {
    }

    public ProductCountProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
