package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "continents_countries",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id"))
    private Set<Continent> continent;

    @OneToMany(mappedBy = "country")
    private Set<Town> town;

    public Set<Town> getTown() {
        return town;
    }

    public void setTown(Set<Town> town) {
        this.town = town;
    }

    public Set<Continent> getContinent() {
        return continent;
    }

    public void setContinent(Set<Continent> continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
