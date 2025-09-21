package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "continent")
    private Set<Country> country;

    public Set<Country> getCountry() {
        return country;
    }

    public void setCountry(Set<Country> country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
