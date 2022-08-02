package com.optum.model;

import java.util.Set;

public class PatientDetails {

    int id;
    Set<String> disease;
    Set<String> risk;

    public PatientDetails(int id, Set<String> disease, Set<String> risk) {
        this.id = id;
        this.disease = disease;
        this.risk = risk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<String> getDisease() {
        return disease;
    }

    public void setDisease(Set<String> disease) {
        this.disease = disease;
    }

    public Set<String> getRisk() {
        return risk;
    }

    public void setRisk(Set<String> risk) {
        this.risk = risk;
    }
}
