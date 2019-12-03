package com.example.sportsbetting.database.repository;

import com.example.sportsbetting.database.model.Outcome;
import org.springframework.data.repository.CrudRepository;

public interface IOutcomeRepository extends CrudRepository<Outcome, Integer> {
}
