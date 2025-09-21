package entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity{

    @Column(name = "home_team_goals")
    private int homeTeamGoals;

    @Column(name = "away_team_goals")
    private int awayTeamGoals;

    @Column(name = "date_time")
    private Timestamp dateTime;

    @Column(name = "home_team_win_bet_rate")
    private BigDecimal homeTeamWinBetRate;

    @Column(name = "away_team_win_bet_rate")
    private BigDecimal awayTeamWinBetRate;

    @Column(name = "draw_game_bet_rate")
    private BigDecimal drawGameBetRate;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round roundId;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competitionId;

    @ManyToOne
    @JoinColumn(name = "home_team")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team")
    private Team awayTeam;

    @ManyToMany(mappedBy = "games")
    private Set<Player> players;


//    @OneToMany(mappedBy = "game")
//    private Set<PlayerStatistic> statistics;
//
//    public Set<PlayerStatistic> getStatistics() {
//        return statistics;
//    }
//
//    public void setStatistics(Set<PlayerStatistic> statistics) {
//        this.statistics = statistics;
//    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(BigDecimal homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    public BigDecimal getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(BigDecimal awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    public BigDecimal getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(BigDecimal drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    public Round getRoundId() {
        return roundId;
    }

    public void setRoundId(Round roundId) {
        this.roundId = roundId;
    }

    public Competition getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Competition competitionId) {
        this.competitionId = competitionId;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
}
