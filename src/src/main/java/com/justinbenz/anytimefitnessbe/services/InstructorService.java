package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor save(Instructor instructor);

    List<Instructor> findAll();

    Instructor findInstructorById(long instructorid);
}
