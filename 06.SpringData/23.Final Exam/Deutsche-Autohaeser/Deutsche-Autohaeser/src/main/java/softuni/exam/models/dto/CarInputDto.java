package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import softuni.exam.models.entity.CarType;

public class CarInputDto {

    @Expose
    @NotNull
    @Size(min = 2, max = 30)
    private String brand;

    @Expose
    @NotNull
    @Size(min = 2, max = 30)
    private String model;

    @Expose
    @NotNull
    @Size(min = 17, max = 17)
    private String VIN;

    @Expose
    @NotNull
    @Positive
    private Integer mileage;

    @Expose
    @NotNull
    @Enumerated
    private CarType carType;

    @Expose
    @NotNull
    private Long dealership;

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

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Long getDealership() {
        return dealership;
    }

    public void setDealershipId(Long dealershipId) {
        this.dealership = dealershipId;
    }
}
