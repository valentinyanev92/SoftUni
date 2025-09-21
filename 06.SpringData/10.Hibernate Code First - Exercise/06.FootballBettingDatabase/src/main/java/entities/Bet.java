package entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "bets")
public class Bet extends BaseEntity{

    @Column(name = "bet_money")
    private BigDecimal betMoney;

    @Column(name = "date_time")
    private Timestamp dateAndTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    public Timestamp getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Timestamp dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
