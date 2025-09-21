package sofuni.exam.models.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "moons")
public class Moon extends BaseClass{

    @Column(name = "discovered", nullable = false)
    private LocalDate discovered;

    @Column(name = "distance_from_planet")
    private Integer distanceFromPlanet;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "radius", nullable = false)
    private Double radius;

    @ManyToOne
    @JoinColumn(name = "discoverer_id", nullable = false)
    private Discoverer discoverer;

    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;

    public LocalDate getDiscovered() {
        return discovered;
    }

    public void setDiscovered(LocalDate discovered) {
        this.discovered = discovered;
    }

    public Integer getDistanceFromPlanet() {
        return distanceFromPlanet;
    }

    public void setDistanceFromPlanet(Integer distanceFromPlanet) {
        this.distanceFromPlanet = distanceFromPlanet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Discoverer getDiscoverer() {
        return discoverer;
    }

    public void setDiscoverer(Discoverer discoverer) {
        this.discoverer = discoverer;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
