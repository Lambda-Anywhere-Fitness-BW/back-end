package com.justinbenz.anytimefitnessbe.repositories;

import com.justinbenz.anytimefitnessbe.models.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {
}
