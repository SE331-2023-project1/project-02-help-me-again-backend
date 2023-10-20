package se331.helpme.project.dao;

import se331.helpme.project.entity.Student;

import java.util.List;

public interface StudentDao {

        Integer getStudentSize();
        List<Student> getStudents(Integer pageSize, Integer page);
        Student getStudent(Long id);
}
