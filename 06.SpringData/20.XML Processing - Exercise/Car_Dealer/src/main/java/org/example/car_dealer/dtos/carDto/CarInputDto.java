package org.example.car_dealer.dtos.carDto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
public class CarInputDto {
    private String make;
    private String model;
    @JacksonXmlProperty(localName = "travelled-distance")
    private Long travelledDistance;

    public CarInputDto() {
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

    public Long getTraveledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
