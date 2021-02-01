package com.justinbenz.anytimefitnessbe.repositories;

import com.justinbenz.anytimefitnessbe.models.Punch;
import org.springframework.data.repository.CrudRepository;

public interface PunchRepository extends CrudRepository<Punch, Long> {
}
