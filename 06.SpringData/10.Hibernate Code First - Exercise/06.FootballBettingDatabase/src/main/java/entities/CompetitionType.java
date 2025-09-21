package entities;

import jakarta.persistence.*;
import values.CompetitionTypes;

import java.util.Set;

@Entity
@Table(name = "competition_types")
public class CompetitionType extends BaseEntity {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CompetitionTypes type;

    @OneToMany(mappedBy = "competitionType")
    private Set<Competition> competitions;

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }

    public CompetitionTypes getType() {
        return type;
    }

    public void setType(CompetitionTypes name) {
        this.type = name;
    }
}
