package com.justinbenz.anytimefitnessbe.controllers;

import com.justinbenz.anytimefitnessbe.services.FitnessClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classes")
public class FitnessClassController {

    @Autowired
    private FitnessClassService fitnessClassService;
}
