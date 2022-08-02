package com.optum.controller;

import com.optum.model.Patient;
import com.optum.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/addpatient")
    public String addPatientInForm(@RequestBody Patient patient){
        patientService.addPatientToForm(patient);
        return "Success";
    }

    @GetMapping("/getpatient")
    public List<Patient> getPatientFromForm(){
        return patientService.getPatientFromForm();
    }

}
