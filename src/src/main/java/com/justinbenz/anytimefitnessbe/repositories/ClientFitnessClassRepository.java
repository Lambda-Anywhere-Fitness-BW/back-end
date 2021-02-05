package com.justinbenz.anytimefitnessbe.repositories;

import com.justinbenz.anytimefitnessbe.models.Client;
import com.justinbenz.anytimefitnessbe.models.ClientFitnessClass;
import com.justinbenz.anytimefitnessbe.models.User;
import org.springframework.data.repository.CrudRepository;

public interface ClientFitnessClassRepository extends CrudRepository<ClientFitnessClass, Long> {
}
