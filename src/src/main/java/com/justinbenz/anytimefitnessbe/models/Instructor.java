package com.justinbenz.anytimefitnessbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long instructorid;

    @OneToMany(mappedBy = "instructor")
    @JsonIgnoreProperties(value = "instructor", allowSetters = true)
    private List<FitnessClass> fitnessClasses = new ArrayList<>();

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private String bio;

    @Column(nullable = false, unique = true)
    private String aviurl;

    @Column(nullable = false, unique = false)
    private int yearsexp;

    @Column(nullable = false, unique = false)
    private String specialty;

    public Instructor() {
    }


}
