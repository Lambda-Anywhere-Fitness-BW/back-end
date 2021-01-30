package com.justinbenz.anytimefitnessbe.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PunchId implements Serializable {

    private long client;

    private long fitnessclass;

    public PunchId() {
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
        PunchId punchId = (PunchId) o;
        return client == punchId.client && fitnessclass == punchId.fitnessclass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, fitnessclass);
    }
}
