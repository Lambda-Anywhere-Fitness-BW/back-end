package com.justinbenz.anytimefitnessbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.justinbenz.anytimefitnessbe.repositories.InstructorRepository;
import com.justinbenz.anytimefitnessbe.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

    @OneToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "instructor", allowSetters = true)
    private User user;

    @Column(nullable = false, unique = false)
    private int yearsexp;

    @Column(nullable = false, unique = false)
    private String specialty;

    public Instructor() {
    }

    public Instructor(List<FitnessClass> fitnessClasses, User user, int yearsexp, String specialty) {
        this.fitnessClasses = fitnessClasses;
        this.user = user;
        this.yearsexp = yearsexp;
        this.specialty = specialty;
    }

    public List<FitnessClass> getFitnessClasses() {
        return fitnessClasses;
    }

    public void setFitnessClasses(List<FitnessClass> fitnessClasses) {
        this.fitnessClasses = fitnessClasses;
    }


    public long getInstructorid() {
        return instructorid;
    }

    public void setInstructorid(long instructorid) {
        this.instructorid = instructorid;
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
}
