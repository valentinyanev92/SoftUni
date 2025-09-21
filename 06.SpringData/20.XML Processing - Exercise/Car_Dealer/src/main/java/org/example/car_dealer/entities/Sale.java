package org.example.car_dealer.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "sales")
public class Sale extends BaseClass{

    @Column(name = "discount")
    private BigDecimal discount;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", nullable = false, unique = true)
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Sale() {
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
