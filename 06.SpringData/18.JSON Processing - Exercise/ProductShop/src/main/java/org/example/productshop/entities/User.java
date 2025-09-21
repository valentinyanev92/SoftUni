package org.example.productshop.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "fist_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Basic
    private Integer age;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    private List<Product> selling;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER)
    private List<Product> bought;

    @ManyToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<User> friends;

    public User() {
        this.selling = new ArrayList<>();
        this.bought = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public List<Product> getSelling() {
        return selling;
    }

    public void setSelling(List<Product> selling) {
        this.selling = selling;
    }

    public List<Product> getBought() {
        return bought;
    }

    public void setBought(List<Product> bought) {
        this.bought = bought;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
