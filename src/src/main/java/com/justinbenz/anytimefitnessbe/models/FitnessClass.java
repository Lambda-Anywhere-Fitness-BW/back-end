package com.justinbenz.anytimefitnessbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fitnessclasses")
public class FitnessClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fitnessclassid;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "instructorid", nullable = false)
    @JsonIgnoreProperties(value = "fitnessclasses", allowSetters = true)
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "fitnessclasstypeid", nullable = false)
    @JsonIgnoreProperties(value = "fitnessclasses", allowSetters = true)
    private FitnessClassType fitnessClassType;

    @OneToMany(mappedBy = "fitnessclass",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "fitnessclass", allowSetters = true)
    private Set<Punch> clients = new HashSet<>();

    public FitnessClass() {
    }

    public FitnessClass(String name, Instructor instructor, FitnessClassType fitnessClassType, Set<Punch> clients) {
        this.name = name;
        this.instructor = instructor;
        this.fitnessClassType = fitnessClassType;
        this.clients = clients;
    }

    public long getFitnessclassid() {
        return fitnessclassid;
    }

    public void setFitnessclassid(long fitnessclassid) {
        this.fitnessclassid = fitnessclassid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public FitnessClassType getFitnessClassType() {
        return fitnessClassType;
    }

    public void setFitnessClassType(FitnessClassType fitnessClassType) {
        this.fitnessClassType = fitnessClassType;
    }

    public Set<Punch> getClients() {
        return clients;
    }

    public void setClients(Set<Punch> clients) {
        this.clients = clients;
    }
}
