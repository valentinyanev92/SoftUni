package sofuni.exam.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class MoonInputDto {

    @XmlElement(name = "name")
    @NotNull
    @Size(min = 2, max = 10)
    private String name;

    @XmlElement(name = "discovered")
    @NotNull
    private String discovered;

    @XmlElement(name = "distance_from_planet")
    @Positive
    private Integer distanceFromPlanet;

    @XmlElement(name = "discoverer_id")
    @NotNull
    private Long discover;

    @XmlElement(name = "radius")
    @NotNull
    @Positive
    private Double radius;

    @XmlElement(name = "planet_id")
    @NotNull
    private Long planet;

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscovered() {
        return discovered;
    }

    public void setDiscovered(String discovered) {
        this.discovered = discovered;
    }

    public Integer getDistanceFromPlanet() {
        return distanceFromPlanet;
    }

    public void setDistanceFromPlanet(Integer distanceFromPlanet) {
        this.distanceFromPlanet = distanceFromPlanet;
    }

    public Long getDiscover() {
        return discover;
    }

    public void setDiscover(Long discover) {
        this.discover = discover;
    }

    public Long getPlanet() {
        return planet;
    }

    public void setPlanet(Long planet) {
        this.planet = planet;
    }
}
