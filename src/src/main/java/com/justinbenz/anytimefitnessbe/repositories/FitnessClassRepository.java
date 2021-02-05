package com.justinbenz.anytimefitnessbe.repositories;

import com.justinbenz.anytimefitnessbe.models.FitnessClass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FitnessClassRepository extends CrudRepository<FitnessClass, Long> {

    List<FitnessClass> findAll();
}
