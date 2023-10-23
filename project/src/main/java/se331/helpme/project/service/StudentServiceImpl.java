package se331.helpme.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.helpme.project.dao.StudentDao;
import se331.helpme.project.entity.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;
    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page){
        return studentDao.getStudents(pageSize,page);
    }
    @Override
    public Student getStudentById(Long id){
        return studentDao.getStudentById(id);
    }

    @Override
    public Page<Student> getStudent(String firstName, Pageable pageable){
        return studentDao.getStudent(firstName, pageable);
    }
    @Override
    public Student save(Student student){
        return studentDao.save(student);
    }
}

