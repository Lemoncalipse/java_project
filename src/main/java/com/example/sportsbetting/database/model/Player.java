package com.example.sportsbetting.database.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "player")
public class Player extends User {

    @Column(name = "name")
    private String name;

    @Column(name = "accountNumber")
    private Integer accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "birth", columnDefinition = "DATE")
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public String getName() {
        return name;
    }
    public Integer getAccountNumber() {
        return accountNumber;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public LocalDate getBirth() {
        return birth;
    }
    public Currency getCurrency() {
        return currency;
    }

    public void setName(String name) { this.name = name; }
    public void setAccountNumber(Integer accountNumber) { this.accountNumber = accountNumber; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public void setBirth(LocalDate birth) { this.birth = birth; }
    public void setCurrency(Currency currency) { this.currency = currency; }

    public static class Builder {
        private String name;
        private Integer accountNumber;
        private BigDecimal balance;
        private LocalDate birth;
        private Currency currency;

        private String email;
        private String password;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setAccountNumber(Integer accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }
        public Builder setBalance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }
        public Builder setBirth(LocalDate birth) {
            this.birth = birth;
            return this;
        }
        public Builder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Player build() {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            Player player = new Player();
            player.name = this.name;
            player.birth = this.birth;
            player.accountNumber = this.accountNumber;
            player.currency = this.currency;
            player.balance = this.balance;

            player.password = encoder.encode(this.password);
            player.email = this.email;
            return player;
        }
    }
}
