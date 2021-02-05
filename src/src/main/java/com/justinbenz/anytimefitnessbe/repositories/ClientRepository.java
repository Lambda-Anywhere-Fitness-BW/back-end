package com.justinbenz.anytimefitnessbe.repositories;

import com.justinbenz.anytimefitnessbe.models.Client;
import com.justinbenz.anytimefitnessbe.models.User;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByUser(User user);

    Client findByUser_Userid(long userid);
}
