package com.nit.MVCProj2DataRendering.controller;


import com.nit.MVCProj2DataRendering.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class FormController {


    @GetMapping("/register")
    public String showForm(@ModelAttribute("stud") Student s) {
        return "show_form";
    }

    @PostMapping("/register")
    public String processStudent(Map<String, Object> map, @ModelAttribute("stud") Student s) {

        String grade = null;

        if(s.getAverage() >= 75)
            grade = "Fist class with Dist";
        else if(s.getAverage() >= 50)
            grade = "First class";
        else if(s.getAverage() >= 60)
            grade = "Second class";
        else if(s.getAverage() >= 35)
            grade = "Third class";
        else
            grade = "Fail";


        // single value put in bindawaremodelmap
        map.put("result", grade);
        map.put("sname", s.getName());
        map.put("sadd", s.getAddress());
        return "show_result";
    }
}
