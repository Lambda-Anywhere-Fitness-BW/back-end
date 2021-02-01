package com.justinbenz.anytimefitnessbe.services;


import com.justinbenz.anytimefitnessbe.repositories.FitnessClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("fitnessClassService")
public class FitnessClassServiceImpl implements FitnessClassService {

    @Autowired
    private FitnessClassRepository fitclassrepos;
}
