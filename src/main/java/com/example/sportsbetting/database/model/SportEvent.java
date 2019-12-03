package com.example.sportsbetting.database.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance
@Table(name = "sportevent")
public abstract class SportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected int id;

    @Column(name = "title")
    protected String title;

    @Column(name = "startDate")
    protected LocalDateTime startDate;

    @Column(name = "endDate", columnDefinition = "TIME")
    protected LocalDateTime endDate;

    @OneToMany(mappedBy = "sportEvent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<Bet> bets;

    @OneToOne
    @JoinColumn(name = "result_id")
    protected Result result;

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public List<Bet> getBets() {
        return bets;
    }
    public Result getResult() {
        return result;
    }

    public static class Builder {
        private String title;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private List<Bet> bets;
        private Result result;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        public Builder setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }
        public Builder setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }
        public Builder setBets(List<Bet> bets) {
            this.bets = bets;
            return this;
        }
        public Builder setResult(Result result) {
            this.result = result;
            return this;
        }
        public SportEvent build(int sportEventType) {
            if(sportEventType == 0) {
                FootballSportEvent footballSportEvent = new FootballSportEvent();
                footballSportEvent.title = this.title;
                footballSportEvent.startDate = this.startDate;
                footballSportEvent.endDate = this.endDate;
                footballSportEvent.bets = this.bets;
                footballSportEvent.result = this.result;

                return footballSportEvent;
            }
            else{
                TennisSportEvent tennisSportEvent = new TennisSportEvent();
                tennisSportEvent.title = this.title;
                tennisSportEvent.startDate = this.startDate;
                tennisSportEvent.endDate = this.endDate;
                tennisSportEvent.bets = this.bets;
                tennisSportEvent.result = this.result;

                return tennisSportEvent;
            }
        }
    }
}
