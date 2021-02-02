package com.justinbenz.anytimefitnessbe.controllers;

import com.justinbenz.anytimefitnessbe.repositories.FitnessClassTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classtypes")
public class FitnessClassTypeController {

    @Autowired
    private FitnessClassTypeRepository fitnessClassTypeRepository;
}
