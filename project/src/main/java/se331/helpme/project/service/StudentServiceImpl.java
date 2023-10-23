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
    final TeacherDao teacherDao;
    final StudentRepository studentRepository;
    final UserDao userDao;
    @Override
    public Integer getStudentsSize() {
        return studentDao.getStudentSize();
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentDao.getStudents(pageSize, page);
    }

    @Override
    public Page<Student> getStudents(String filter, Pageable pageable) {
        return studentDao.getStudents(filter,pageable);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentDao.getStudents(Pageable.unpaged()).getContent();
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.getStudent(id);
    }

    @Override
    public List<Student> getStudentsByTeacher(Long id) {
        return teacherDao.getTeacher(id).getOwnStudent();
    }
    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student updateDetail(Student student) {
        Student updateStudent = studentDao.getStudent(student.getId());
        if (updateStudent != null) {
            updateStudent.getUser().setFirstname(student.getName());
            updateStudent.getUser().setLastname(student.getSurname());


            studentDao.save(updateStudent);


            userDao.save(updateStudent.getUser());
            return updateStudent;
        }
        return null;
    }
}


