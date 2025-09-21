package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "positions")
public class Position{

    @Id
    @Column(name = "id", nullable = false, length = 2)
    private String id;

    @Column(name = "position_desctiption")
    private String positionDescription;

    @OneToMany(mappedBy = "positionId")
    private Set<Player> players;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
