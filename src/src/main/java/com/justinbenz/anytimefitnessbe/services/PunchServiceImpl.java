package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.repositories.PunchRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PunchServiceImpl implements PunchService{

    @Autowired
    private PunchRepository punchrepos;
}
