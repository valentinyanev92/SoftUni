package org.example.productshop.dtos;

import org.example.productshop.entities.Product;

import java.math.BigDecimal;

public class ProductSoldDTO {

    private String name;
    private BigDecimal price;
    private String buyerFirstName;
    private String buyerLastName;

    public ProductSoldDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.buyerFirstName = product.getSeller().getFirstName();
        this.buyerLastName = product.getSeller().getLastName();
    }

    public ProductSoldDTO() {
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

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }
}
