package com.example.Hospital.management.system.Controller;

import com.example.Hospital.management.system.Model.Doctor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class DoctorController {

     HashMap<Integer, Doctor> doctorDb = new HashMap<>();

     @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor){

         int doctorId = doctor.getDoctorId();

         doctorDb.put(doctorId, doctor);

         return "Doctor added successfully";
     }
}
