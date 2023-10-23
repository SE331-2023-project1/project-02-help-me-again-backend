package se331.helpme.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se331.helpme.project.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAll();

    Page<Student> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrStudent_ID
            (String name, String surName, String studentID, String advisorName, Pageable PageRequest);
}


