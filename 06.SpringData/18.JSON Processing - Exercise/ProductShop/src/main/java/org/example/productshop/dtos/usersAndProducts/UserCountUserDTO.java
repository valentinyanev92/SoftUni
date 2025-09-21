package org.example.productshop.dtos.usersAndProducts;

import org.example.productshop.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserCountUserDTO {

    private String firstName;
    private String lastName;
    private int age;
    private List<ProductCountDTO> soldProducts;

    public UserCountUserDTO() {
    }

    public UserCountUserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();

        this.soldProducts = new ArrayList<>();

        ProductCountDTO productCountDTO = new ProductCountDTO(user.getSelling());
        this.soldProducts.add(productCountDTO);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<ProductCountDTO> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductCountDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
