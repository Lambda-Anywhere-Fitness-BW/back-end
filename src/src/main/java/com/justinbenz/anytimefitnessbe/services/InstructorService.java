package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor save(Instructor instructor);

    Instructor update(Instructor instructor, long id);

    List<Instructor> findAll();

    Instructor findInstructorById(long instructorid);

    void delete(long id);
}
