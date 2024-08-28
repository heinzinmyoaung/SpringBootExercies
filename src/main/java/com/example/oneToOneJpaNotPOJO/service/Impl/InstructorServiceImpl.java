package com.example.oneToOneJpaNotPOJO.service.Impl;

import com.example.oneToOneJpaNotPOJO.entity.Instructor;
import com.example.oneToOneJpaNotPOJO.repository.InstructorRepo;
import com.example.oneToOneJpaNotPOJO.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    InstructorRepo instructorRepo;

    @Override
    public List<Instructor> getInstructorAll() {
        return instructorRepo.findAll();
    }
}
