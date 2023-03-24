package com.example.Hospital.management.system.Controller;
import java.util.*;

import com.example.Hospital.management.system.Model.Nurse;
import com.example.Hospital.management.system.Service.NurseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nures")
public class NuresController {

    NurseService nurseService = new NurseService();
    @PostMapping("/addNurse")
    public String addNures(@RequestBody Nurse nurse){

        String ans = nurseService.addNurse(nurse);

        return ans;
    }

    @GetMapping("/getNurseListByAge")
    public List<Nurse> getNurseGreaterThenAge(@RequestParam("age")Integer age){

        List<Nurse> nurseList = nurseService.getList(age);

        return nurseList;
    }

    @GetMapping("/getListByQualification")
    public List<Nurse> getNurseListByQualification(@RequestParam("qualification")String qualification){

         List<Nurse> list = nurseService.getListNurseQualification(qualification);

         return list;
    }
}
