package entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    private String logo;

    @Column(name = "initials", length = 3)
    private String initials;

    @ManyToOne
    @JoinColumn(name = "primary_kit_color_id")
    private Color primaryKitColor;

    @ManyToOne
    @JoinColumn(name = "secondary_kit_color_id")
    private Color secondaryKitColor;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;

    @Column(name = "budget")
    private BigDecimal budget;

    @OneToMany(mappedBy = "teamId")
    private Set<Player> players;

    @OneToMany(mappedBy = "homeTeam")
    private Set<Game> homeTeams;

    @OneToMany(mappedBy = "awayTeam")
    private Set<Game> awayTeams;

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logoULR) {
        this.logo = logoULR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

}
