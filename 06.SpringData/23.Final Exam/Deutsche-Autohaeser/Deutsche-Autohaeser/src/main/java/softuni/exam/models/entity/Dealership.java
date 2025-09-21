package softuni.exam.models.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "dealerships")
public class Dealership extends BaseEntity{

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "dealership")
    private Set<Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
