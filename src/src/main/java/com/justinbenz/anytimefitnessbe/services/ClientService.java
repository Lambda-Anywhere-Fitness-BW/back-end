package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.Client;

import java.util.List;

public interface ClientService {

    Client save(Client client);

    List<Client> findAll();

    Client findClientById(long clientid);
}
