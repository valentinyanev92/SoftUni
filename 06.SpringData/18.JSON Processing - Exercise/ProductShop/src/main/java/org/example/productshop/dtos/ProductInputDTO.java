package org.example.productshop.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.example.productshop.entities.User;

import java.math.BigDecimal;

public class ProductInputDTO {

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    private User seller;
    private User buyer;

    public ProductInputDTO() {
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
