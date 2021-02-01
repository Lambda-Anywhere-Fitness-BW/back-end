package com.justinbenz.anytimefitnessbe.services;


import com.justinbenz.anytimefitnessbe.repositories.FitnessClassTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("fitnessClassTypeService")
public class FitnessClassTypeServiceImpl implements FitnessClassTypeService{

    @Autowired
    private FitnessClassTypeRepository fitclasstyperepos;
}
