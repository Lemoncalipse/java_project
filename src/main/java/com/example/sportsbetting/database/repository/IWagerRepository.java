package com.example.sportsbetting.database.repository;

import com.example.sportsbetting.database.model.Player;
import com.example.sportsbetting.database.model.Wager;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IWagerRepository extends CrudRepository<Wager, Integer> {
    List<Wager> findByPlayer(Player player);
}