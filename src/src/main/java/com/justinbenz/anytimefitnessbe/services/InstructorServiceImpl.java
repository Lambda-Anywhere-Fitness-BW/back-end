package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.exceptions.ResourceNotFoundException;
import com.justinbenz.anytimefitnessbe.models.Instructor;
import com.justinbenz.anytimefitnessbe.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
                    .orElseThrow(() -> new ResourceNotFoundException("Instructorid " + instructor.getInstructorid() + " not found!"));
            newTeach.setInstructorid(instructor.getInstructorid());
        }

        newTeach.setSpecialty(instructor.getSpecialty());
        newTeach.setYearsexp(instructor.getYearsexp());

        return instructrepos.save(instructor);
    }

    @Override
    public List<Instructor> findAll() {

        List<Instructor> instructors =  new ArrayList<>();
        instructrepos.findAll().iterator().forEachRemaining(instructors::add);

        return instructors;
    }

    @Override
    public Instructor findInstructorById(long instructorid) {

       return instructrepos.findById(instructorid).orElseThrow(() -> new ResourceNotFoundException("Instructor"));
    }
}
