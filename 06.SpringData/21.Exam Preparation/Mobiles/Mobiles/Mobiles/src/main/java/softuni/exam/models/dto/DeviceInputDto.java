package softuni.exam.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import softuni.exam.models.entity.DeviceType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceInputDto {

    @XmlElement(name = "brand")
    @NotNull
    @Size(min=2,max=20)
    private String brand;

    @XmlElement(name = "device_type")
    private DeviceType deviceType;

    @XmlElement(name = "model")
    @NotNull
    @Size(min=1,max=20)
    private String model;

    @XmlElement(name = "price")
    @Positive
    private Double price;

    @XmlElement(name = "storage")
    @Positive
    private Integer storage;

    @XmlElement(name = "sale_id")
    private Long sale;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Long getSale() {
        return sale;
    }

    public void setSale(Long saleId) {
        this.sale = saleId;
    }
}
