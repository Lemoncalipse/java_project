package com.example.sportsbetting.database.repository;

import com.example.sportsbetting.database.model.OutcomeOdd;
import org.springframework.data.repository.CrudRepository;

public interface IOutcomeOddRepository extends CrudRepository<OutcomeOdd, Integer> {
}