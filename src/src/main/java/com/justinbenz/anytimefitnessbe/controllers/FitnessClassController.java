package com.justinbenz.anytimefitnessbe.controllers;

import com.justinbenz.anytimefitnessbe.models.Client;
import com.justinbenz.anytimefitnessbe.models.FitnessClass;
import com.justinbenz.anytimefitnessbe.services.FitnessClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class FitnessClassController {

    @Autowired
    private FitnessClassService fitnessClassService;

    @GetMapping(value = "/all", produces = "application/json")
    private ResponseEntity<?> getAllClasses(){
        List<FitnessClass> myClasses = fitnessClassService.findAll();
        return new ResponseEntity<>(myClasses, HttpStatus.OK);
    }

    @DeleteMapping(value = "/class/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id) {
        fitnessClassService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
