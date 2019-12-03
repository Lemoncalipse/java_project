package com.example.sportsbetting.database.model;

import javax.persistence.*;

@Entity
@Inheritance
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name ="email", unique = true)
    protected String email;

    @Column(name = "password")
    protected String password;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}