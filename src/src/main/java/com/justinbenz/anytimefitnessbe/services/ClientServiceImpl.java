package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.Client;
import com.justinbenz.anytimefitnessbe.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientrepos;

    @Transactional
    @Override
    public Client save(Client client) {
        Client newClient = new Client();

        if (client.getClientid() != 0) {
            clientrepos.findById(client.getClientid())
                    .orElseThrow(() -> new EntityNotFoundException("User id " + client.getClientid() + " not found!"));
            newClient.setClientid(client.getClientid());
        }

        newClient.setFitnesslevel(client.getFitnesslevel());
        newClient.setLocation(client.getLocation());

        return clientrepos.save(client);
    }
}
