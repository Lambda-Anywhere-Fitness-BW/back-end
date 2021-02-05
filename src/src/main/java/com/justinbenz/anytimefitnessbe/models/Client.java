package com.justinbenz.anytimefitnessbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clientid;

    @OneToMany(mappedBy = "client",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties(value = "client",
    allowSetters = true)
    private Set<ClientFitnessClass> clientfitnessclasses = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "client", allowSetters = true)
    private User user;

    @Column
    private int fitnesslevel;

    @Column
    private String location;

    public Client() {
    }

    public Client(Set<ClientFitnessClass> clientfitnessclasses, User user, int fitnesslevel, String location) {
        this.clientfitnessclasses = clientfitnessclasses;
        this.user = user;
        this.fitnesslevel = fitnesslevel;
        this.location = location;
    }

    public void setClientid(long clientid) {
        this.clientid = clientid;
    }

    public long getClientid() {
        return clientid;
    }

    public Set<ClientFitnessClass> getClientfitnessclasses() {
        return clientfitnessclasses;
    }

    public void setClientfitnessclasses(Set<ClientFitnessClass> clientfitnessclasses) {
        this.clientfitnessclasses = clientfitnessclasses;
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
