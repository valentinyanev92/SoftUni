package org.example.car_dealer.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cars")
public class Car extends BaseClass{

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "travelled_distance")
    private long travelledDistance;

    @ManyToMany(mappedBy = "cars", fetch = FetchType.EAGER)
    private List<Part> parts;

    @OneToOne(mappedBy = "car", fetch = FetchType.EAGER)
    private Sale sale;

    public Car() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTraveledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
