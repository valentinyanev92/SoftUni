package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "players")
public class Player extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "squad_number")
    private String squadNumber;

    @Column(name = "is_injured")
    private Boolean isInjured;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position positionId;

    @ManyToOne
    @JoinColumn(name = "team_id_id")
    private Team teamId;

    @ManyToMany
    @JoinTable(name = "player_statistics",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> games;

//    @OneToMany(mappedBy = "player")
//    private List<PlayerStatistic> statistics;
//
//
//    public List<PlayerStatistic> getStatistics() {
//        return statistics;
//    }
//
//    public void setStatistics(List<PlayerStatistic> statistics) {
//        this.statistics = statistics;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(String squadNumber) {
        this.squadNumber = squadNumber;
    }

    public Boolean getInjured() {
        return isInjured;
    }

    public void setInjured(Boolean injured) {
        isInjured = injured;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }
}
