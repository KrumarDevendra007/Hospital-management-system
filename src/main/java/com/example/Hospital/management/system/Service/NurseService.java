package com.example.Hospital.management.system.Service;

import com.example.Hospital.management.system.Model.Nurse;
import com.example.Hospital.management.system.Repository.NurseRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NurseService {

    NurseRepository nurseRepository = new NurseRepository();

    public String addNurse(Nurse nurse){

        if(nurse.getNurseId() < 0){
            return "Enter a valid nurseId";
        }
        if(nurse.getName().equals(null)){
            return "Nurse name should not be null";
        }

        String ans = nurseRepository.addNurse(nurse);

        return ans;
    }

    public List<Nurse> getList(int age){

        List<Nurse> list = nurseRepository.getAllNurseList();

        List<Nurse> finalList = new ArrayList<>();
        for(Nurse nurse : list){

            if(nurse.getAge() > age){
                finalList.add(nurse);
            }
        }

        return finalList;
    }

    public List<Nurse> getListNurseQualification(String qualification){

        List<Nurse> list = nurseRepository.getAllNurseList();

        List<Nurse> nurseList = new ArrayList<>();

        for(Nurse nurse : list){
            if(nurse.getQualification().equals(qualification)){
                nurseList.add(nurse);
            }
        }

        return nurseList;

    }
}
