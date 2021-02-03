package com.justinbenz.anytimefitnessbe.controllers;


import com.justinbenz.anytimefitnessbe.models.Client;
import com.justinbenz.anytimefitnessbe.models.Instructor;
import com.justinbenz.anytimefitnessbe.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructors/")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping(value = "/instructors", produces = "application/json")
    public ResponseEntity<?> getAllInstructors(){
        List<Instructor> myInstructor = instructorService.findAll();
        return new ResponseEntity<>(myInstructor, HttpStatus.OK);
    }

    @GetMapping(value = "/instructors/{instructorid}", produces = "application/json")
    public ResponseEntity<?> getInstructorById(@PathVariable Long instructorid){
        Instructor i = instructorService.findInstructorById(instructorid);
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
}
