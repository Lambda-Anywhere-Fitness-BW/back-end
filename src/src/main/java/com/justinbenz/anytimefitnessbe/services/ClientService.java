package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.Client;
import com.justinbenz.anytimefitnessbe.models.ClientFitnessClass;
import com.justinbenz.anytimefitnessbe.models.ClientFitnessClassPunches;
import com.justinbenz.anytimefitnessbe.models.User;

import java.util.List;

public interface ClientService {

    Client save(Client client);

    Client update(Client client, long id);

    List<Client> findAll();

    Client findClientById(long clientid);

    Client clientJoinClass(long cfcid, ClientFitnessClassPunches clientFitnessClassPunches, User user);
}
