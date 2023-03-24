package com.example.Hospital.management.system.Controller;

import com.example.Hospital.management.system.Model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PatientController {

    HashMap<Integer, Patient> patientDb = new HashMap<>();
    @PostMapping("/addPatientViaRequestParameter") // Post data by request parameter
    public String addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("name")String name,
                             @RequestParam("disease")String disease, @RequestParam("age")Integer age){

        Patient patient = new Patient(patientId, name,disease,age);
        patientDb.put(patientId, patient);

        return "Patient added successfully via Request Parameter";
    }
    @PostMapping("/addPatientVisRequestBody") // Post data by request body
    public String addPatient(@RequestBody Patient patient){

        int key = patient.getPatientId();

        patientDb.put(key, patient);

        return "Patient added successfully via Request Body";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatientInfo(@RequestParam("patientId")Integer patientId){

        Patient patient = patientDb.get(patientId);

        return patient;
    }

    @GetMapping("/getPatientViaPathVariable/{patientId}")
    public Patient getPatientInfos(@PathVariable("patientId")Integer patientId){

        Patient patient = patientDb.get(patientId);

        return patient;
    }

    @GetMapping("/getPatientAgeAndDisease/{age}/{disease}")
    public List<Patient> getInfo(@PathVariable("age")Integer age, @PathVariable("disease")String disease){

         List<Patient> patientList = new ArrayList<>();

        for(Patient p : patientDb.values()){

            if(p.getAge() > age && p.getDisease().equals(disease)){
                patientList.add(p);
            }
        }

        return patientList;
    }


    @GetMapping("/getAllPatienInfo")
    public List<Patient> getAllPatientInfo(){

        List<Patient> patientList = new ArrayList<>();

        for(Patient p : patientDb.values()){

            patientList.add(p);
        }

        return  patientList;
    }

    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name")String name){

        for(Patient p : patientDb.values()){
            if(p.getName() == name){
                return p;
            }
        }

        return null;
    }

    @GetMapping("/getPatientListGreaterThenAge")
    public List<Patient> getPatientListGreaterThenAge(@RequestParam("age")Integer age){

        List<Patient> patientList = new ArrayList<>();

        for(Patient p : patientDb.values()){

            if(p.getAge() > age){
                patientList.add(p);
            }
        }

        return patientList;
    }

    @PostMapping("/updateDisease")
    public String updteDisease(@RequestParam("patientId")Integer patientId, @RequestParam("disease")String disease){

        if(patientDb.containsKey(patientId)){

            Patient patient = patientDb.get(patientId);

            patient.setDisease(disease);

            patientDb.put(patientId, patient);

            return "Update Successfully";
        }

        return "Patient dose not exist";
    }

    @PostMapping("/uptadePatientInfo")
    public String updatePatientInfo(@RequestBody Patient patient){

        int key = patient.getPatientId();

        if(patientDb.containsKey(key)){
            patientDb.put(key, patient);
            return "Patient added successfully";
        }

        return "Patient dose not exist";
    }

    @DeleteMapping("/deletePatientInfo")
    public String deletePatientInfo( @RequestParam("patientId")Integer patientId){
        patientDb.remove(patientId);

            return "Delete Successfully";
        }
}
