package org.example.productshop.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {

    @NotEmpty
    @Size(min = 3)
    private String name;

    @NotEmpty
    @Positive
    private BigDecimal price;

    private UserDTO buyerId;

    @NotEmpty
    private UserDTO sellerId;

    private List<CategoryDTO> categories;

    public ProductDTO() {
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

    public UserDTO getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(UserDTO buyerId) {
        this.buyerId = buyerId;
    }

    public UserDTO getSellerId() {
        return sellerId;
    }

    public void setSellerId(UserDTO sellerId) {
        this.sellerId = sellerId;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
