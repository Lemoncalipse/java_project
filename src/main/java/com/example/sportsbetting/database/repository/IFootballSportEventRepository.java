package com.example.sportsbetting.database.repository;

import com.example.sportsbetting.database.model.FootballSportEvent;
import org.springframework.data.repository.CrudRepository;

public interface IFootballSportEventRepository extends CrudRepository<FootballSportEvent, Integer> {
}
