package com.example.sportsbetting.database.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wager")
public class Wager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int Id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "timeStampCreated", columnDefinition = "DATE")
    private LocalDateTime timeStampCreated;

    @Column(name = "processed")
    private boolean processed;

    @Column(name = "win")
    private boolean win;

    @OneToOne
    @JoinColumn(name = "odd_id")
    private OutcomeOdd odd;

    @OneToOne
    @JoinColumn(name = "player_id")
    private User player;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public int getId() {
        return Id;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public LocalDateTime getTimeStampCreated() {
        return timeStampCreated;
    }
    public boolean isProcessed() {
        return processed;
    }
    public boolean isWin() {
        return win;
    }
    public OutcomeOdd getOdd() {
        return odd;
    }
    public User getPlayer() {
        return player;
    }
    public Currency getCurrency() {
        return currency;
    }

    public static class Builder {
        private BigDecimal amount;
        private LocalDateTime timeStampCreated;
        private boolean processed;
        private boolean win;
        private OutcomeOdd odd;
        private User player;
        private Currency currency;

        public Builder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder setTimeStampCreated(LocalDateTime timeStampCreated) {
            this.timeStampCreated = timeStampCreated;
            return this;
        }

        public Builder setProcessed(boolean processed) {
            this.processed = processed;
            return this;
        }

        public Builder setWin(boolean win) {
            this.win = win;
            return this;
        }

        public Builder setOdd(OutcomeOdd odd) {
            this.odd = odd;
            return this;
        }

        public Builder setPlayer(User user) {
            this.player = user;
            return this;
        }

        public Builder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }


        public Wager build() {
            Wager wager = new Wager();
            wager.amount = this.amount;
            wager.currency = this.currency;
            wager.odd = this.odd;
            wager.player = this.player;
            wager.processed = this.processed;
            wager.timeStampCreated = this.timeStampCreated;

            return wager;
        }
    }
}
