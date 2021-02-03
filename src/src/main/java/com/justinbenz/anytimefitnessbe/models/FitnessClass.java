package com.justinbenz.anytimefitnessbe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fitnessclasses")
public class FitnessClass extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fitnessclassid;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private String starttime;

    @Column(nullable = false, unique = false)
    private String duration;

    @Column(nullable = false, unique = false)
    private int intensitylevel;

    @Column(nullable = false, unique = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "instructorid", nullable = false)
    @JsonIgnoreProperties(value = "fitnessclasses", allowSetters = true)
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "fitnessclasstypeid", nullable = false)
    @JsonIgnoreProperties(value={"fitnessclasses"}, allowSetters = true)
    private FitnessClassType fitnessclasstype;

    @OneToMany(mappedBy = "fitnessclass",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "fitnessclasses", allowSetters = true)
    private Set<ClientFitnessClass> clients = new HashSet<>();


    public FitnessClass() {
    }

    public FitnessClass(String name, String starttime, String duration, int intensitylevel, String location, Instructor instructor, FitnessClassType fitnessclasstype, Set<ClientFitnessClass> clients) {
        this.name = name;
        this.starttime = starttime;
        this.duration = duration;
        this.intensitylevel = intensitylevel;
        this.location = location;
        this.instructor = instructor;
        this.fitnessclasstype = fitnessclasstype;
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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getIntensitylevel() {
        return intensitylevel;
    }

    public void setIntensitylevel(int intensitylevel) {
        this.intensitylevel = intensitylevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public FitnessClassType getFitnessclasstype() {
        return fitnessclasstype;
    }

    public void setFitnessclasstype(FitnessClassType fitnessClassType) {
        this.fitnessclasstype = fitnessClassType;
    }

    public Set<ClientFitnessClass> getClients() {
        return clients;
    }

    public void setClients(Set<ClientFitnessClass> clients) {
        this.clients = clients;
    }
}
