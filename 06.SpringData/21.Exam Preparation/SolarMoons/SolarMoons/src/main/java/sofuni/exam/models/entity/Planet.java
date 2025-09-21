package sofuni.exam.models.entity;

import jakarta.persistence.*;
import sofuni.exam.models.enums.Type;

import java.util.Set;

@Entity
@Table(name = "planets")
public class Planet extends BaseClass{
    @Column(name = "diameter", nullable = false)
    private Integer diameter;

    @Column(name = "distance_from_sun", nullable = false)
    private Long distanceFromSun;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "orbital_period", nullable = false)
    private Double orbitalPeriod;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "planet")
    private Set<Moon> moons;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Moon> getMoons() {
        return moons;
    }

    public void setMoons(Set<Moon> moons) {
        this.moons = moons;
    }
}
