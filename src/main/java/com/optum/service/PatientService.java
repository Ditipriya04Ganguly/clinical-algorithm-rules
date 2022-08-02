package com.optum.service;

import com.optum.model.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    List<Patient> patientList= new ArrayList<>();

    public void addPatientToForm(Patient patient){
        patientList.add(patient);
    }

    public List<Patient> getPatientFromForm(){
        return patientList;
    }
}
