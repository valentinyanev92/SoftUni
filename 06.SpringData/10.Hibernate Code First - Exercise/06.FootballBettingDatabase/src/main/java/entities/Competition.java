package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "competition_type")
    private CompetitionType competitionType;

    @OneToMany(mappedBy = "competitionId")
    private Set<Game> games;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }
}
