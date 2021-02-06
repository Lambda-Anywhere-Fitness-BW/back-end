package com.justinbenz.anytimefitnessbe.services;


import com.justinbenz.anytimefitnessbe.exceptions.ResourceNotFoundException;
import com.justinbenz.anytimefitnessbe.models.FitnessClass;
import com.justinbenz.anytimefitnessbe.repositories.FitnessClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("fitnessClassService")
public class FitnessClassServiceImpl implements FitnessClassService {

    @Autowired
    private FitnessClassRepository fcrepos;

    @Override
    public List<FitnessClass> findAll() {
        List<FitnessClass> list = new ArrayList<>();

        fcrepos.findAll().iterator().forEachRemaining(list::add);
       return list;
    }

    @Override
    public void delete(long id) throws ResourceNotFoundException {
        fcrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("class with id: " + id + " was not found!"));
        fcrepos.deleteById(id);
    }

    @Override
    public FitnessClass findFcById(long id) {
        return fcrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("fitness class with id: " + id + " was not found!"));
    }
}
