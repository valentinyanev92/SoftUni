package softuni.exam.models.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity{

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "vin", nullable = false, unique = true)
    private String VIN;

    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @Column(name = "car_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private softuni.exam.models.entity.CarType carType;

    @ManyToOne()
    @JoinColumn(name = "dealership_id", nullable = false)
    private Dealership dealership;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public softuni.exam.models.entity.CarType getCarType() {
        return carType;
    }

    public void setCarType(softuni.exam.models.entity.CarType carType) {
        this.carType = carType;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }
}
