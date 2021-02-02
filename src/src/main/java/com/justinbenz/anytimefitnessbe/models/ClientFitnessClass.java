package com.justinbenz.anytimefitnessbe.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clientfitnessclass")
@IdClass(ClientFitnessClassId.class)
public class ClientFitnessClass implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    @Id
    @ManyToOne
    @JoinColumn(name = "fitnessclassid")
    private FitnessClass fitnessclass;

    @Column(nullable = false, unique = false)
    private final int maxpunches = 10;

    @Column(nullable = false, unique = false)
    private int punches;

    public ClientFitnessClass() {
    }

    public ClientFitnessClass(Client client, FitnessClass fitnessclass, int punches) {
        this.client = client;
        this.fitnessclass = fitnessclass;
        this.punches = punches;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public FitnessClass getFitnessclass() {
        return fitnessclass;
    }

    public void setFitnessclass(FitnessClass fitnessclass) {
        this.fitnessclass = fitnessclass;
    }

    public int getMaxpunches() {
        return maxpunches;
    }

    public int getPunches() {
        return punches;
    }

    public void setPunches(int punches) {
        this.punches = punches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientFitnessClass that = (ClientFitnessClass) o;
        return this.client.getClientid() == that.client.getClientid() && this.fitnessclass.getFitnessclassid() == that.fitnessclass.getFitnessclassid();
    }

    @Override
    public int hashCode() {
        return 666;
    }
}

