package com.optum.controller;

import com.optum.model.ListOfPatient;
import com.optum.model.Patient;
import com.optum.model.PatientDetails;
import com.optum.service.PatientDisease;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class CarController {



    //@Autowired

    private KieSession ksession;
    @Autowired
    KieContainer kieContainer;


    @PostMapping("/patient")
    public  List<PatientDetails> addPatient(@RequestBody ListOfPatient listOfPatient){
        ksession= kieContainer.newKieSession();

        PatientDisease patientDisease= new PatientDisease();

        for (Patient patient: listOfPatient.getListofpatient()){
            ksession.insert(patient);
        }


        System.out.println("abc");
        ksession.insert(LocalDate.now());
        ksession.insert(patientDisease);
        ksession.fireAllRules();
        ksession.dispose();


        /*for(Patient p1: patientDisease.getMaplist().keySet())
        {
            System.out.print("patient with id "+p1.getId()+" has disease ");
            System.out.println(patientDisease.getMaplist().get(p1));
            System.out.println("Prefill value: "+ p1.getPreFill());
            System.out.println("Multiple value: "+p1.getMultiple());
            System.out.println("Multiple Risk prefill: "+p1.getMultipleG());
            System.out.println("Risk Factor: "+p1.getRisk());
        }*/

        //System.out.println(patientDisease.searchPatientById(patient.getId()));
        //System.out.println(patientDisease.getMaplist().get(patient));

        List<PatientDetails> patientDetails= new ArrayList<>();
        for (int p:listOfPatient.getAllPatientId()) {
            if (patientDisease.searchPatientById(p) != null) {
                PatientDetails patientdetails = new PatientDetails(patientDisease.searchPatientById(p).getId(), patientDisease.getMaplist().get(patientDisease.searchPatientById(p)), patientDisease.searchPatientById(p).getRisk());
                patientDetails.add(patientdetails);
            }
        }
        return patientDetails;
    }

    @PostMapping("/perpatient")
    public  List<PatientDetails> addOnePatient(@RequestBody Patient patient){
        ksession= kieContainer.newKieSession();

        PatientDisease patientDisease= new PatientDisease();


            ksession.insert(patient);




        ksession.insert(LocalDate.now());
        ksession.insert(patientDisease);
        ksession.fireAllRules();
        ksession.dispose();


        List<PatientDetails> patientDetails= new ArrayList<>();
            PatientDetails patientdetails = new PatientDetails(patientDisease.searchPatientById(patient.getId()).getId(), patientDisease.getMaplist().get(patientDisease.searchPatientById(patient.getId())), patientDisease.searchPatientById(patient.getId()).getRisk());
            patientDetails.add(patientdetails);

        return patientDetails;
    }

    @GetMapping("/patient/{id}")
    public ListOfPatient getPatient(@PathVariable(name = "id") int id){
        Patient p= new Patient(1,"R13.1", "Active",LocalDate.of(2022,06,30), LocalDate.of(2000,9,04));
        List<Patient> plist= new ArrayList<>();
        plist.add(p);
        ListOfPatient list= new ListOfPatient(plist);
        return list;
    }

}
