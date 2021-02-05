package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.Client;

import java.util.List;

public interface ClientService {

    Client save(Client client);

    Client update(Client client, long id);

    List<Client> findAll();

    Client findClientById(long clientid);
}
