package com.example.sportsbetting.database.repository;

import com.example.sportsbetting.database.model.TennisSportEvent;
import org.springframework.data.repository.CrudRepository;

public interface ITennisSportEventRepository extends CrudRepository<TennisSportEvent, Integer> {
        }