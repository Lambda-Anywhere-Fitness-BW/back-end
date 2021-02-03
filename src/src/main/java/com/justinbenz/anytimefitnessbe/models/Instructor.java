package com.justinbenz.anytimefitnessbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long instructorid;

    @OneToMany(mappedBy = "instructor")
    @JsonIgnoreProperties(value = {"instructor", "fitnessclasses", "clients"}, allowSetters = true)
    private List<FitnessClass> fitnessClasses = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "instructor", allowSetters = true)
    private User user;

    @Column(nullable = false, unique = false)
    private int yearsexp;

    @Column(nullable = false, unique = false)
    private String specialty;

    @Column(nullable = false, unique = false)
    private String credentials;

    public Instructor() {
    }

    public Instructor(List<FitnessClass> fitnessClasses, User user, int yearsexp, String specialty, String credentials) {
        this.fitnessClasses = fitnessClasses;
        this.user = user;
        this.yearsexp = yearsexp;
        this.specialty = specialty;
        this.credentials = credentials;
    }

    public void setInstructorid(long instructorid) {
        this.instructorid = instructorid;
    }

    public long getInstructorid() {
        return instructorid;
    }

    public List<FitnessClass> getFitnessClasses() {
        return fitnessClasses;
    }

    public void setFitnessClasses(List<FitnessClass> fitnessClasses) {
        this.fitnessClasses = fitnessClasses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getYearsexp() {
        return yearsexp;
    }

    public void setYearsexp(int yearsexp) {
        this.yearsexp = yearsexp;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
}
