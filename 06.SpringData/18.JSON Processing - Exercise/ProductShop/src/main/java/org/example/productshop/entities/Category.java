package org.example.productshop.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private List<Product> products;

    public Category() {
        this.products = new ArrayList<>();
    }

    public Category(String name) {
        this();
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
