package com.example.oneToOneJpaNotPOJO.controller;


import com.example.oneToOneJpaNotPOJO.entity.Instructor;
import com.example.oneToOneJpaNotPOJO.response.Basic;
import com.example.oneToOneJpaNotPOJO.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    InstructorService instructorService;

//    @GetMapping("/")
//    public List<Instructor> getInstructorAll(){
//        return instructorService.getInstructorAll();
//    }
    @GetMapping("/")
    public ResponseEntity<Basic> getInstructorAll(){
        System.out.println("HOME Controller");
        return instructorService.getInstructorAll();
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test response");
    }
    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable ("id") int id){
        return instructorService.getInstructorById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Basic> createInstructor(@RequestBody Instructor instructor){
        return instructorService.createInstructor(instructor);
    }

    @PutMapping("/{id}")
    public String updateInstructor(@PathVariable ("id")  int id,
                                   @RequestPart Instructor instructor) {

        return instructorService.updateInstructor(id,instructor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Basic> deleteInstructor(@PathVariable ("id")  int id) {
        return instructorService.deleteInstructor(id);
    }
}

