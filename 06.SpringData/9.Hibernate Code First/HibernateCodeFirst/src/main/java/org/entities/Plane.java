package org.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "planes")
public class Plane extends Vehicle {

    @Column(name = "passenger_capacity")
    private Integer passengerCapacity;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}