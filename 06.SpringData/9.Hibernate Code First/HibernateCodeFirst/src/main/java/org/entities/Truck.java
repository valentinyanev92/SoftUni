package org.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {

    @Column(name = "load_capacity")
    private Double loadCapacity;

//    @ManyToMany
//    private Set<Driver> drivers;

//    public Set<Driver> getDrivers() {
//        return drivers;
//    }
//
//    public void setDrivers(Set<Driver> drivers) {
//        this.drivers = drivers;
//    }

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
