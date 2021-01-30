package com.justinbenz.anytimefitnessbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clientid;

    @OneToMany(mappedBy = "client",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties(value = "client",
    allowSetters = true)
    private Set<Punch> fitnessClasses = new HashSet<>();

    @Column
    private String name;

    @Column
    private String aviurl;

    @Column
    private String bio;

    @Column
    private int fitnesslevel;

    @Column
    private String location;


    public Client() {
    }

    public Client(Set<Punch> fitnessClasses, String name, String aviurl, String bio, int fitnesslevel, String location) {
        this.fitnessClasses = fitnessClasses;
        this.name = name;
        this.aviurl = aviurl;
        this.bio = bio;
        this.fitnesslevel = fitnesslevel;
        this.location = location;
    }

    public long getClientid() {
        return clientid;
    }

    public void setClientid(long clientid) {
        this.clientid = clientid;
    }

    public Set<Punch> getFitnessClasses() {
        return fitnessClasses;
    }

    public void setFitnessClasses(Set<Punch> fitnessClasses) {
        this.fitnessClasses = fitnessClasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAviurl() {
        return aviurl;
    }

    public void setAviurl(String aviurl) {
        this.aviurl = aviurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getFitnesslevel() {
        return fitnesslevel;
    }

    public void setFitnesslevel(int fitnesslevel) {
        this.fitnesslevel = fitnesslevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
