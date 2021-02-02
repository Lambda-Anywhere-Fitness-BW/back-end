package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.Instructor;
import com.justinbenz.anytimefitnessbe.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service("instructorService")
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorRepository instructrepos;

    @Override
    public Instructor save(Instructor instructor) {
        Instructor newTeach = new Instructor();

        if(instructor.getInstructorid() != 0){
            instructrepos.findById(instructor.getInstructorid())
                    .orElseThrow(() -> new EntityNotFoundException("User id " + instructor.getInstructorid() + " not found!"));
            newTeach.setInstructorid(instructor.getInstructorid());
        }

        newTeach.setSpecialty(instructor.getSpecialty());
        newTeach.setYearsexp(instructor.getYearsexp());

        return instructrepos.save(instructor);
    }
}
