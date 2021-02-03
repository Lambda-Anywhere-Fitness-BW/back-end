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

    @OneToMany(mappedBy = "fitnessclasstype", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "fitnessclasstypes", allowSetters = true)
    private Set<FitnessClass> fitnessclasses = new HashSet<>();


    @Column(nullable = false, unique = true)
    private String name;

    public FitnessClassType() {
    }

    public FitnessClassType(Set<FitnessClass> fitnessclasses, String name) {
        this.fitnessclasses = fitnessclasses;
        this.name = name;
    }

    public long getFitnessclasstypeid() {
        return fitnessclasstypeid;
    }

    public void setFitnessclasstypeid(long fitnessclasstypeid) {
        this.fitnessclasstypeid = fitnessclasstypeid;
    }

    public Set<FitnessClass> getFitnessclasses() {
        return fitnessclasses;
    }

    public void setFitnessclasses(Set<FitnessClass> fitnessClasses) {
        this.fitnessclasses = fitnessClasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}