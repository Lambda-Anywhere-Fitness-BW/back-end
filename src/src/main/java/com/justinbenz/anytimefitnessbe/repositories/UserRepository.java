package com.justinbenz.anytimefitnessbe.repositories;

import com.justinbenz.anytimefitnessbe.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
