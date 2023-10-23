package se331.helpme.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.helpme.project.entity.Student;

import java.util.List;

public interface StudentService {
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudentById(Long id);

    Page<Student> getStudent(String firstName, Pageable pageable);
    Student save(Student student);
}

