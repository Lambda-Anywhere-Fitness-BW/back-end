package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.exceptions.ResourceNotFoundException;
import com.justinbenz.anytimefitnessbe.models.*;
import com.justinbenz.anytimefitnessbe.repositories.ClientFitnessClassRepository;
import com.justinbenz.anytimefitnessbe.repositories.ClientRepository;
import com.justinbenz.anytimefitnessbe.repositories.FitnessClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "clientFitnessClassService")
public class ClientFitnessClassServiceImpl implements ClientFitnessClassService {

    @Autowired
    private FitnessClassRepository fcrepos;

    @Autowired
    private ClientFitnessClassRepository cfcrepos;

    @Autowired
    private ClientRepository clientrepos;

}
