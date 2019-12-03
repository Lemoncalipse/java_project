package com.example.sportsbetting.database.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "outcome")
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "bet_id")
    private Bet bet;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "outcomeodd_id")
    private List<OutcomeOdd> outcomeOdds;

    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public Bet getBet() {
        return bet;
    }
    public List<OutcomeOdd> getOutcomeOdds() {
        return outcomeOdds;
    }

    public static class Builder {
        private String description;
        private Bet bet;
        private List<OutcomeOdd> outcomeOdds;

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setBet(Bet bet) {
            this.bet = bet;
            return this;
        }
        public Builder setOutcomeOdds(List<OutcomeOdd> outcomeOdds) {
            this.outcomeOdds = outcomeOdds;
            return this;
        }

        public Outcome build() {
            Outcome outcome = new Outcome();
            outcome.description = this.description;
            outcome.bet = this.bet;
            outcome.outcomeOdds = this.outcomeOdds;

            return outcome;
        }
    }
}