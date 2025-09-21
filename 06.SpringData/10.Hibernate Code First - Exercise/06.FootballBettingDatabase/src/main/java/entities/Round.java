package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rounds")
public class Round extends BaseEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "roundId")
    private Set<Game> games;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
