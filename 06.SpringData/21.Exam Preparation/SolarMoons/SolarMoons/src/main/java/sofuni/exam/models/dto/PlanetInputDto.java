package sofuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import sofuni.exam.models.enums.Type;

public class PlanetInputDto {

    @Expose
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @Expose
    @NotNull
    @Positive
    private Integer diameter;

    @Expose
    @NotNull
    @Positive
    private Long distanceFromSun;

    @Expose
    @NotNull
    @Positive
    private Double orbitalPeriod;

    @Expose
    @NotNull
    private Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public Long getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(Long distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
