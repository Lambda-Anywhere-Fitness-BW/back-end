package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("instructorService")
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorRepository instructrepos;
}
