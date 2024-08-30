package com.example.oneToOneJpaNotPOJO.service;

import com.example.oneToOneJpaNotPOJO.entity.Instructor;
import com.example.oneToOneJpaNotPOJO.response.Basic;
import org.springframework.http.ResponseEntity;

public interface InstructorService {

//    List<Instructor> getInstructorAll();
    ResponseEntity<Basic> getInstructorAll();

    Instructor getInstructorById(int id);

//    String createInstructor(Instructor instructor);
    ResponseEntity<Basic> createInstructor(Instructor instructor);
    String updateInstructor(int id, Instructor instructor);

    ResponseEntity<Basic> deleteInstructor(int id);
}









