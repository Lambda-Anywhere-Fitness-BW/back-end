package com.justinbenz.anytimefitnessbe.controllers;


import com.justinbenz.anytimefitnessbe.models.Client;
import com.justinbenz.anytimefitnessbe.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/clients", produces = "application/json")
    public ResponseEntity<?> getAllClients(){
        List<Client> myClients = clientService.findAll();
        return new ResponseEntity<>(myClients, HttpStatus.OK);
    }

    @GetMapping(value = "/clients/{clientid}", produces = "application/json")
    public ResponseEntity<?> getClientById(@PathVariable Long clientid){
        Client c = clientService.findClientById(clientid);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

}
