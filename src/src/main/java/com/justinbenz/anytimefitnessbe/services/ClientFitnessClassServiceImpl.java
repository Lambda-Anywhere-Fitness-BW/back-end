package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.repositories.ClientFitnessClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientFitnessClassServiceImpl implements ClientFitnessClassService {

    @Autowired
    private ClientFitnessClassRepository punchrepos;
}
