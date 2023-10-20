package se331.helpme.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.helpme.project.dao.StudentDao;
import se331.helpme.project.entity.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;

    @Override
    public Integer getStudentSize() {
        return studentDao.getStudentSize();
    }

    @Override
    public List<Student> getStudents(Integer pageSize, Integer page) {
        return studentDao.getStudents(pageSize, page);
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.getStudent(id);
    }
}

