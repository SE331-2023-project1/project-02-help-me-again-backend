package se331.helpme.project.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.helpme.project.entity.Student;

public interface StudentDao {

        Integer getStudentSize();
        Student save(Student student);
        Page<Student> getStudents(Integer pageSize, Integer page);
        Page<Student> getStudents(Pageable page);
        Student getStudent(Long id);

        Page<Student> getStudents(String filter, Pageable page);

}

