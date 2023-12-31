package se331.helpme.project.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.helpme.project.entity.Student;
import se331.helpme.project.repository.StudentRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoDbImpl implements StudentDao {

    final StudentRepository studentRepository;
    @Override
    public Integer getStudentSize() {
        return Math.toIntExact(studentRepository.count());
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<Student> getStudents(Pageable page) {
        return studentRepository.findAll(page);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Student> getStudents(String filter, Pageable page) {
        return studentRepository.findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrUser_UsernameIgnoreCaseContaining(filter,filter,filter,page);
    }
}




