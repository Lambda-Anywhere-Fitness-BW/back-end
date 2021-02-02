package com.justinbenz.anytimefitnessbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fitnessclasstypes")
public class FitnessClassType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fitnessclasstypeid;

    @OneToMany(mappedBy = "fitnessClassType", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "fitnessClassType", allowSetters = true)
    private Set<FitnessClass> fitnessClasses = new HashSet<>();


    @Column(nullable = false, unique = true)
    private String name;

    public FitnessClassType() {
    }

    public FitnessClassType(Set<FitnessClass> fitnessClasses, String name) {
        this.fitnessClasses = fitnessClasses;
        this.name = name;
    }

    public long getFitnessclasstypeid() {
        return fitnessclasstypeid;
    }

    public void setFitnessclasstypeid(long fitnessclasstypeid) {
        this.fitnessclasstypeid = fitnessclasstypeid;
    }

    public Set<FitnessClass> getFitnessClasses() {
        return fitnessClasses;
    }

    public void setFitnessClasses(Set<FitnessClass> fitnessClasses) {
        this.fitnessClasses = fitnessClasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}