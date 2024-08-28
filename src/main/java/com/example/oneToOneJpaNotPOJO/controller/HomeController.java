package com.example.oneToOneJpaNotPOJO.controller;


import com.example.oneToOneJpaNotPOJO.entity.Instructor;
import com.example.oneToOneJpaNotPOJO.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    InstructorService instructorService;

    @GetMapping(name = "/")
    public List<Instructor> getInstructorAll(){
        return instructorService.getInstructorAll();
    }
}
