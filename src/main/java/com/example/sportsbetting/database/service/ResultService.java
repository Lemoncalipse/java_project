package com.example.sportsbetting.database.service;

import com.example.sportsbetting.database.model.Result;
import com.example.sportsbetting.database.repository.IResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultService {
    @Autowired
    IResultRepository repository;

    public void add(Result result) {
        repository.save(result);
    }
}