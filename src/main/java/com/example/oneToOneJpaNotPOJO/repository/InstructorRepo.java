package com.example.oneToOneJpaNotPOJO.repository;

import com.example.oneToOneJpaNotPOJO.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor,Integer> {

}
