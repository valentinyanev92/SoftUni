package org.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "plate_numbers")
public class PlateNumber{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "plate_number")
    private String number;

    @OneToOne(mappedBy = "plateNumber")
    @JoinColumn(name = "plateNumberId")
    private Car car;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
