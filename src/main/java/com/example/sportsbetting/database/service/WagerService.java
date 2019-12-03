package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.Player;
import com.example.sportsbetting.database.model.Wager;
import com.example.sportsbetting.database.repository.IWagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class WagerService {
    @Autowired
    IWagerRepository repository;

    public void add(Wager wager) {
        repository.save(wager);
    }
    public void delete(int id) {
        repository.deleteById(id);
    }
    public List<Wager> getWagersByPlayer(Player player) {
        return repository.findByPlayer(player);
    }
}