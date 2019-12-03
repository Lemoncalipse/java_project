package com.example.sportsbetting.database.model;

import javax.persistence.Id;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "outcomeodd")
public class OutcomeOdd {
        
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private int id;

        @Column(name="value")
        private BigDecimal value;

        @Column(name="validFrom")
        private LocalDateTime validFrom;

        @Column(name="validUntil")
        private LocalDateTime validUntil;

        @ManyToOne(cascade=CascadeType.ALL)
        @JoinColumn(name = "outcome_id")
        private Outcome outcome;

        public int getId() {
                return id;
        }
        public BigDecimal getValue() {
                return value;
        }
        public LocalDateTime getValidFrom() {
                return validFrom;
        }
        public LocalDateTime getValidUntil() {
                return validUntil;
        }
        public Outcome getOutcome() {
                return outcome;
        }

        public static class Builder {
                private BigDecimal value;
                private LocalDateTime validFrom;
                private LocalDateTime validUntil;
                private Outcome outcome;

                public Builder setValue(BigDecimal value) {
                        this.value = value;
                        return this;
                }
                public Builder setValidFrom(LocalDateTime validFrom) {
                        this.validFrom = validFrom;
                        return this;
                }
                public Builder setValidUntil(LocalDateTime validUntil) {
                        this.validUntil = validUntil;
                        return this;
                }
                public Builder setOutcome(Outcome outcome) {
                        this.outcome = outcome;
                        return this;
                }

                public OutcomeOdd build() {
                        OutcomeOdd outcomeOdd = new OutcomeOdd();
                        outcomeOdd.value = this.value;
                        outcomeOdd.validFrom = this.validFrom;
                        outcomeOdd.validUntil = this.validUntil;
                        outcomeOdd.outcome = this.outcome;

                        return outcomeOdd;
                }
        }
}
