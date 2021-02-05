package com.justinbenz.anytimefitnessbe.controllers;


import com.justinbenz.anytimefitnessbe.models.Client;
import com.justinbenz.anytimefitnessbe.models.Instructor;
import com.justinbenz.anytimefitnessbe.models.User;
import com.justinbenz.anytimefitnessbe.repositories.UserRepository;
import com.justinbenz.anytimefitnessbe.services.ClientService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserRepository userrepos;

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

    @PostMapping(value = "/clients/new", produces = "application/json",  consumes = "application/json")
    public ResponseEntity<?> addNewClient(@RequestBody @Valid Client client){
        client = clientService.save(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients/classes", produces = "application/json")
    public ResponseEntity<?> getClientClasses(){
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userrepos.findByUsername(currentUsername);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
