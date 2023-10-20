package se331.helpme.project.service;

import se331.helpme.project.entity.Student;

import java.util.List;

public interface StudentService {
    Integer getStudentSize();
    List<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long id);
}

