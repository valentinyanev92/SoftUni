package sofuni.exam.models.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "discoverers",
uniqueConstraints = {@UniqueConstraint(columnNames = {"first_name", "last_name"})})
public class Discoverer extends BaseClass{

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "occupation")
    private String occupation;

    @OneToMany(mappedBy = "discoverer")
    private Set<Moon> moons;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Set<Moon> getMoons() {
        return moons;
    }

    public void setMoons(Set<Moon> moons) {
        this.moons = moons;
    }
}
