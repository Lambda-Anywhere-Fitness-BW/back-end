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
    private Set<ClientFitnessClass> fitnessClasses = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @Column
    private int fitnesslevel;

    @Column
    private String location;

    public Client() {
    }

    public Client(Set<ClientFitnessClass> fitnessClasses, User user, int fitnesslevel, String location) {
        this.fitnessClasses = fitnessClasses;
        this.user = user;
        this.fitnesslevel = fitnesslevel;
        this.location = location;
    }

    public Set<ClientFitnessClass> getFitnessClasses() {
        return fitnessClasses;
    }

    public void setFitnessClasses(Set<ClientFitnessClass> fitnessClasses) {
        this.fitnessClasses = fitnessClasses;
    }

    public long getClientid() {
        return clientid;
    }

    public void setClientid(long clientid) {
        this.clientid = clientid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
