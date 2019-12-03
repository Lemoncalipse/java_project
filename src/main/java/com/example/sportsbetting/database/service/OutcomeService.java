package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.Outcome;
import com.example.sportsbetting.database.repository.IOutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutcomeService {
    @Autowired
    IOutcomeRepository repository;

    public void add(Outcome outcome) {
        repository.save(outcome);
    }
}