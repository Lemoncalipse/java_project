package com.example.sportsbetting.database.repository;

import com.example.sportsbetting.database.model.Result;
import org.springframework.data.repository.CrudRepository;

public interface IResultRepository extends CrudRepository<Result, Integer> {
}