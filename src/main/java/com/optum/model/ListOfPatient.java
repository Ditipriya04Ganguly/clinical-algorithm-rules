package com.optum.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ListOfPatient {

     List<Patient> listofpatient;

    public ListOfPatient(){

    }

    public ListOfPatient(List<Patient> listofpatient) {
        this.listofpatient = listofpatient;
    }

    public List<Patient> getListofpatient() {
        return listofpatient;
    }

    public void setListofpatient(List<Patient> listofpatient) {
        this.listofpatient = listofpatient;
    }

    @Override
    public String toString() {
        return "ListOfPatient{" +
                "listofpatient=" + listofpatient +
                '}';
    }

    public Set<Integer> getAllPatientId(){
        Set<Integer> pid= new HashSet<>();
        for (Patient patient: listofpatient){
            pid.add(patient.getId());
        }
        return pid;
    }
}
