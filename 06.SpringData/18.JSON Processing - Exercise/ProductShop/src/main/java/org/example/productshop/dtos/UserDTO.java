package org.example.productshop.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;


public class UserDTO {

    private String fistName;

    @NotEmpty
    @Size(min = 3)
    private String lastName;

    @Positive
    private int age;

    private List<ProductDTO> productsSold;
    private List<ProductDTO> productBought;
    private List<UserDTO> friends;

    public UserDTO() {
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
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

    public List<ProductDTO> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(List<ProductDTO> productsSold) {
        this.productsSold = productsSold;
    }

    public List<ProductDTO> getProductBought() {
        return productBought;
    }

    public void setProductBought(List<ProductDTO> productBought) {
        this.productBought = productBought;
    }

    public List<UserDTO> getFriends() {
        return friends;
    }

    public void setFriends(List<UserDTO> friends) {
        this.friends = friends;
    }
}
