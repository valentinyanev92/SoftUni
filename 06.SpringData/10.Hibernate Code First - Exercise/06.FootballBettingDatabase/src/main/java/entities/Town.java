package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}