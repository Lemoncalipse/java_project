package com.example.sportsbetting.database.repository;

import com.example.sportsbetting.database.model.Bet;
import org.springframework.data.repository.CrudRepository;

public interface IBetRepository extends CrudRepository<Bet, Integer> {
}