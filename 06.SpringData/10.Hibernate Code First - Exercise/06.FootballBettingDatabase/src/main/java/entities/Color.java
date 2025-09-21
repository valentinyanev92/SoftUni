package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "colors")
public class Color extends BaseEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "primaryKitColor")
    private List<Team> teams;

    @OneToMany(mappedBy = "secondaryKitColor")
    private List<Team> teams2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams2() {
        return teams2;
    }

    public void setTeams2(List<Team> teams2) {
        this.teams2 = teams2;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
