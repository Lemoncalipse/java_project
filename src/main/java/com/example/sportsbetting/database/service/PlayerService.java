package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.Player;
import com.example.sportsbetting.database.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {
    @Autowired
    IPlayerRepository repository;

    public void add(Player player) {
        repository.save(player);
    }
    public void save(Player player) {
        repository.save(player);
    }
    public Player getPlayerByEmail(String email) {
        return repository.findByEmail(email);
    }
}