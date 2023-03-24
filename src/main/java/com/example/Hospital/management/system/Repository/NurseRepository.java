package com.example.Hospital.management.system.Repository;

import com.example.Hospital.management.system.Model.Nurse;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class NurseRepository {

    HashMap<Integer, Nurse> nurseDb = new HashMap<>();
    public String addNurse(Nurse nurse){

        int key = nurse.getNurseId();
        nurseDb.put(key, nurse);

        return "Nurse added successfully";
    }

    public List<Nurse> getAllNurseList(){

        return nurseDb.values().stream().toList();
    }

}
