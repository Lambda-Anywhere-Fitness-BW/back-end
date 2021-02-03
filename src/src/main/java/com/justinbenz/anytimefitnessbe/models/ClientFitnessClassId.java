package com.justinbenz.anytimefitnessbe.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientFitnessClassId extends Auditable implements Serializable {

    private long client;

    private long fitnessclass;

    public ClientFitnessClassId() {
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    public long getFitnessclass() {
        return fitnessclass;
    }

    public void setFitnessclass(long fitnessclass) {
        this.fitnessclass = fitnessclass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientFitnessClassId clientFitnessClassId = (ClientFitnessClassId) o;
        return client == clientFitnessClassId.client && fitnessclass == clientFitnessClassId.fitnessclass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, fitnessclass);
    }
}
