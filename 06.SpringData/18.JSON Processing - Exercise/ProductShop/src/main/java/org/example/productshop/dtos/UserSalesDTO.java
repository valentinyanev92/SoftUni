package org.example.productshop.dtos;

import org.example.productshop.entities.Product;
import org.example.productshop.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserSalesDTO {

    private String firstName;
    private String lastName;
    private List<ProductSoldDTO> soldProducts;

    public UserSalesDTO() {
    }

    public UserSalesDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.soldProducts = new ArrayList<>();
        for (Product product : user.getSelling()) {
            soldProducts.add(new ProductSoldDTO(product));
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductSoldDTO> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductSoldDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
