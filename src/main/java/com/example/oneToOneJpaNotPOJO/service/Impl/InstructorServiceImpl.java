package com.example.oneToOneJpaNotPOJO.service.Impl;

import com.example.oneToOneJpaNotPOJO.entity.Instructor;
import com.example.oneToOneJpaNotPOJO.repository.InstructorRepo;
import com.example.oneToOneJpaNotPOJO.response.Basic;
import com.example.oneToOneJpaNotPOJO.service.InstructorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.oneToOneJpaNotPOJO.response.ResponseFactory;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    ResponseFactory responseFactory;
    @Autowired
    InstructorRepo instructorRepo;


//    @Override
//    public List<Instructor> getInstructorAll() {
//        return instructorRepo.findAll();
//    }
    @Override
    public ResponseEntity<Basic> getInstructorAll() {
        try {
//            Pageable pageable = PageRequest.of(0, 10);
//            List<Instructor> instructors = instructorRepo.findAll(pageable).getContent();;
            long time = System.currentTimeMillis();
            List<Instructor> instructors = instructorRepo.findAll();
            String duration = String.valueOf(System.currentTimeMillis() - time);
            return responseFactory.buildSuccess(HttpStatus.OK, duration, instructors, "SUCCESS", "Success");
        }catch (Exception e){
            log.error("Error: {}, {}", e.getMessage());
            return  responseFactory.buildError(HttpStatus.BAD_REQUEST, null,e.getMessage(), "FAIL", "Success");
        }

    }

    @Override
    public Instructor getInstructorById(int id) {
        return instructorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

//    @Override
//    public String createInstructor(Instructor instructor) {
//        try {
//            instructorRepo.save(instructor);
//            return "Instructor created successfully";
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return  "Instructor created unsuccessfully";
//        }
//    }
    @Override
    public ResponseEntity<Basic> createInstructor(Instructor instructor) {
        try {
            long time = System.currentTimeMillis();
            instructorRepo.save(instructor);
            String duration = String.valueOf(System.currentTimeMillis() - time);
            return responseFactory.buildSuccess(HttpStatus.OK, duration, instructor, "SUCCESS", "Instructor created unsuccessfully");
        }catch (Exception e){
            log.error("Error: {}, {}",  e.getMessage());
            return  responseFactory.buildError(HttpStatus.BAD_REQUEST, null,e.getMessage(), "FAIL", "Instructor created unsuccessfully");
        }
    }

    @Override
    public String updateInstructor(int id, Instructor instructor) {
        Optional<Instructor> optionalInstructor = instructorRepo.findById(id);

        if (!optionalInstructor.isPresent()){return "Account not found";}
        // Get the existing instructor
        Instructor existingInstructor = optionalInstructor.get();

        existingInstructor.setFirstName(instructor.getFirstName());
        existingInstructor.setLastName(instructor.getLastName());
        existingInstructor.setEmail(instructor.getEmail());
        existingInstructor.setInstructorDetail(instructor.getInstructorDetail());
        try {
            instructorRepo.save(existingInstructor);
            return "Instructor updated successfully";
        }catch (Exception e){
            log.error("Error: {}, {}", e.getMessage());
            return  "Instructor updated unsuccessfully";
        }
    }
    @Override
    public String deleteInstructor(int id) {
        if (instructorRepo.existsById(id)) {
            try {
                instructorRepo.deleteById(id);
                return "Instructor deleted successfully";
            }catch (Exception e){
                return "Instructor deleted unsuccessfully";
            }
        }else {return "id not found";}
    }


}
