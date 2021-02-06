package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.exceptions.ResourceNotFoundException;
import com.justinbenz.anytimefitnessbe.models.*;
import com.justinbenz.anytimefitnessbe.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientrepos;

    @Autowired
    private UserRepository userrepos;

    @Autowired
    private ClientFitnessClassRepository cfcrepos;

    @Autowired
    private FitnessClassRepository fcrepos;

    @Autowired
    private FitnessClassTypeRepository cfctyperepos;

    @Transactional
    @Override
    public Client save(Client client) {
        Client newClient = new Client();

        if (client.getClientid() != 0) {
            clientrepos.findById(client.getClientid())
                    .orElseThrow(() -> new ResourceNotFoundException("Client with id " + client.getClientid() + " not found!"));
            newClient.setClientid(client.getClientid());
        }

        newClient.setFitnesslevel(client.getFitnesslevel());
        newClient.setLocation(client.getLocation());

        User user = userrepos.findById(client.getUser().getUserid()).orElseThrow(() -> new ResourceNotFoundException("User with id" + client.getUser().getUserid() + " not found!"));
        newClient.setUser(user);

        if(client.getClientfitnessclasses().size() > 0) {
            for (ClientFitnessClass cfc : client.getClientfitnessclasses()) {
                FitnessClass fitnessClass = fcrepos.findById(cfc.getFitnessclass().getFitnessclassid()).orElseThrow(() -> new ResourceNotFoundException("fitness class with id: " + cfc.getFitnessclass().getFitnessclassid() + "was not found"));
                newClient.getClientfitnessclasses().add(new ClientFitnessClass (newClient, fitnessClass));
                System.out.println(newClient);
            }
        }
        return clientrepos.save(newClient);
    }

    @Override
    public Client update(Client client, long id) {
        Client currentClient = findClientById(id);

        if(client.getFitnesslevel() != 0){
            currentClient.setFitnesslevel(client.getFitnesslevel());
        }

        if(client.getLocation() != null){
            currentClient.setLocation(client.getLocation());
        }

        if(client.getUser() != null){
            User user = userrepos.findById(client.getUser().getUserid()).orElseThrow(() -> new ResourceNotFoundException("User with id: " + client.getUser().getUserid() + " was not found!"));
            currentClient.setUser(user);
        }

        if(client.getClientfitnessclasses().size() > 0) {
            for (ClientFitnessClass cfc : client.getClientfitnessclasses()) {
                FitnessClass fitnessClass = fcrepos.findById(cfc.getFitnessclass().getFitnessclassid()).orElseThrow(() -> new ResourceNotFoundException("fitness class with id: " + cfc.getFitnessclass().getFitnessclassid() + "was not found"));
                currentClient.getClientfitnessclasses().add(new ClientFitnessClass (currentClient, fitnessClass));
            }
        }
        return clientrepos.save(currentClient);
    }

    @Override
    public List<Client> findAll() {
        List<Client> list = new ArrayList<>();

        clientrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Client findClientById(long clientid) {
        return clientrepos.findById(clientid).orElseThrow(() -> new EntityNotFoundException("Client with id" + clientid + "Not found!"));
    }

    @Transactional
    @Override
    public Client clientJoinClass(long fcid, ClientFitnessClassPunches clientFitnessClassPunches, User user) {
        Client client = clientrepos.findByUser_Userid(user.getUserid());
        if (client == null) {
            throw new ResourceNotFoundException("Client class with id: " + user.getUserid() + " was not found!");
        }
        FitnessClass fitnessClass = fcrepos.findById(fcid).orElseThrow(() -> new ResourceNotFoundException("fitness class with id: " + fcid + " was not found!"));
        System.out.println(fitnessClass);
        System.out.println(client);
        ClientFitnessClass newCfc = new ClientFitnessClass(client, fitnessClass, clientFitnessClassPunches.getPunches());
        client.getClientfitnessclasses().add(newCfc);
        return save(client);
    }
}
