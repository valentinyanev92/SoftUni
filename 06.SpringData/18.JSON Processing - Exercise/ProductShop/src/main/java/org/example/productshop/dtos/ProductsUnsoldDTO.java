package org.example.productshop.dtos;

import org.example.productshop.entities.Product;

import java.math.BigDecimal;

public class ProductsUnsoldDTO {

    private String name;
    private BigDecimal price;
    private String seller;

    public ProductsUnsoldDTO() {

    }

    public ProductsUnsoldDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();

        if (product.getSeller().getFirstName() != null) {
            this.seller = product.getSeller().getFirstName() + " " + product.getSeller().getLastName();
        }else {
            this.seller = product.getSeller().getLastName();
        }
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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
