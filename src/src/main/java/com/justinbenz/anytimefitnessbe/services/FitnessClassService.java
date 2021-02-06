package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.FitnessClass;

import java.util.List;

public interface FitnessClassService {

    List<FitnessClass> findAll();

    FitnessClass findFcById(long id);

    void delete(long id);
}
