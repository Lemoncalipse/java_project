package com.example.sportsbetting.database.repository;

import com.example.sportsbetting.database.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface IPlayerRepository extends CrudRepository<Player, Integer> {
    Player findByEmail(String email);
}