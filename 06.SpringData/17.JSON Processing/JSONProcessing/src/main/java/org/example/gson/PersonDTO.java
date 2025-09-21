package org.example.gson;


import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.List;

public class PersonDTO {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int age;

    private boolean isMarried;

    @Expose
    private Date birthDay;

    @Expose
    private AddressDTO address;

    @Expose
    private List<String> friends;


    public PersonDTO(String firstName, String lastName, int age, boolean isMarried, Date birthDay, AddressDTO address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
        this.birthDay = birthDay;
        this.address = address;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                ", birthDay=" + birthDay +
                ", address=" + address +
                ", friends=" + friends +
                '}';
    }
}
