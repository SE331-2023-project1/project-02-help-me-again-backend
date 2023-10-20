package se331.helpme.project.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.helpme.project.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    List<Student> studentList;

    @PostConstruct
    public void init() {
        studentList = new ArrayList<>();
        studentList.add(Student.builder()
                .id(1L)
                .firstName("Emily")
                .lastName("Johnson")
                .student_ID("STID-1001")
                .registered("Mathematics, English Literature, History, Physics, Spanish")
                .advisor(101L)
                .stu_pic("https://randomuser.me/api/portraits/women/1.jpg")
                .build());

        studentList.add(Student.builder()
                .id(2L)
                .firstName("Ethan")
                .lastName("Smith")
                .student_ID("STID-1002")
                .registered("Physics, Computer Science, Spanish, Biology, Chemistry")
                .advisor(102L)
                .stu_pic("https://randomuser.me/api/portraits/men/2.jpg")
                .build());

        studentList.add(Student.builder()
                .id(3L)
                .firstName("Olivia")
                .lastName("Martinez")
                .student_ID("STID-1003")
                .registered("Biology, Chemistry, French, Geography, Art")
                .advisor(103L)
                .stu_pic("https://randomuser.me/api/portraits/women/3.jpg")
                .build());

        studentList.add(Student.builder()
                .id(4L)
                .firstName("Liam")
                .lastName("Anderson")
                .student_ID("STID-1004")
                .registered("Economics, Mathematics, Psychology, English Literature, Music")
                .advisor(104L)
                .stu_pic("https://randomuser.me/api/portraits/men/4.jpg")
                .build());

        studentList.add(Student.builder()
                .id(5L)
                .firstName("Ava")
                .lastName("Thompson")
                .student_ID("STID-1005")
                .registered("Art, Music, Physical Education, Spanish, History")
                .advisor(105L)
                .stu_pic("https://randomuser.me/api/portraits/women/5.jpg")
                .build());

        studentList.add(Student.builder()
                .id(6L)
                .firstName("Noah")
                .lastName("Williams")
                .student_ID("STID-1006")
                .registered("English Literature, History, Geography, Chemistry, Biology")
                .advisor(106L)
                .stu_pic("https://randomuser.me/api/portraits/men/6.jpg")
                .build());

        studentList.add(Student.builder()
                .id(7L)
                .firstName("Sophia")
                .lastName("Brown")
                .student_ID("STID-1007")
                .registered("Mathematics, Physics, Biology, Psychology, Computer Science")
                .advisor(107L)
                .stu_pic("https://randomuser.me/api/portraits/women/7.jpg")
                .build());

        studentList.add(Student.builder()
                .id(8L)
                .firstName("Jackson")
                .lastName("Davis")
                .student_ID("STID-1008")
                .registered("Chemistry, Computer Science, English, Geography, Economics")
                .advisor(108L)
                .stu_pic("https://randomuser.me/api/portraits/men/8.jpg")
                .build());

        studentList.add(Student.builder()
                .id(9L)
                .firstName("Isabella")
                .lastName("Rodriguez")
                .student_ID("STID-1009")
                .registered("Spanish, Art, Psychology, Music, French")
                .advisor(109L)
                .stu_pic("https://randomuser.me/api/portraits/women/9.jpg")
                .build());

        studentList.add(Student.builder()
                .id(10L)
                .firstName("Aiden")
                .lastName("Wilson")
                .student_ID("STID-1010")
                .registered("Geography, History, Economics, Mathematics, English Literature")
                .advisor(110L)
                .stu_pic("https://randomuser.me/api/portraits/men/10.jpg")
                .build());

        studentList.add(Student.builder()
                .id(11L)
                .firstName("Mia")
                .lastName("Taylor")
                .student_ID("STID-1011")
                .registered("Biology, Chemistry, Music, Spanish, Physical Education")
                .advisor(101L)
                .stu_pic("https://randomuser.me/api/portraits/women/11.jpg")
                .build());

        studentList.add(Student.builder()
                .id(12L)
                .firstName("Lucas")
                .lastName("Moore")
                .student_ID("STID-1012")
                .registered("Mathematics, Physics, Computer Science, History, Chemistry")
                .advisor(102L)
                .stu_pic("https://randomuser.me/api/portraits/men/12.jpg")
                .build());

        studentList.add(Student.builder()
                .id(13L)
                .firstName("Harper")
                .lastName("Garcia")
                .student_ID("STID-1013")
                .registered("English Literature, History, French, Geography, Art")
                .advisor(103L)
                .stu_pic("https://randomuser.me/api/portraits/women/13.jpg")
                .build());

        studentList.add(Student.builder()
                .id(14L)
                .firstName("Benjamin")
                .lastName("Jackson")
                .student_ID("STID-1014")
                .registered("Economics, Psychology, Spanish, Music, Biology")
                .advisor(104L)
                .stu_pic("https://randomuser.me/api/portraits/men/14.jpg")
                .build());

        studentList.add(Student.builder()
                .id(15L)
                .firstName("Amelia")
                .lastName("Lee")
                .student_ID("STID-1015")
                .registered("Geography, Art, Physical Education, English Literature, Chemistry")
                .advisor(105L)
                .stu_pic("https://randomuser.me/api/portraits/women/15.jpg")
                .build());

        studentList.add(Student.builder()
                .id(16L)
                .firstName("Henry")
                .lastName("Harris")
                .student_ID("STID-1016")
                .registered("Music, English Literature, Mathematics, Physics, Psychology")
                .advisor(106L)
                .stu_pic("https://randomuser.me/api/portraits/men/16.jpg")
                .build());

        studentList.add(Student.builder()
                .id(17L)
                .firstName("Ella")
                .lastName("Clark")
                .student_ID("STID-1017")
                .registered("Chemistry, Biology, Spanish, Computer Science, Economics")
                .advisor(107L)
                .stu_pic("https://randomuser.me/api/portraits/women/17.jpg")
                .build());

        studentList.add(Student.builder()
                .id(18L)
                .firstName("Alexander")
                .lastName("White")
                .student_ID("STID-1018")
                .registered("Physics, Computer Science, Geography, History, French")
                .advisor(108L)
                .stu_pic("https://randomuser.me/api/portraits/men/18.jpg")
                .build());

        studentList.add(Student.builder()
                .id(19L)
                .firstName("Charlotte")
                .lastName("Hall")
                .student_ID("STID-1019")
                .registered("History, Economics, Psychology, Biology, Music")
                .advisor(109L)
                .stu_pic("https://randomuser.me/api/portraits/women/19.jpg")
                .build());
    }

    @Override
    public Integer getStudentSize() {
        return studentList.size();
    }

    @Override
    public List<Student> getStudents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? studentList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return studentList.subList(firstIndex, firstIndex+pageSize);
    }

    @Override
    public Student getStudent(Long id) {
        return  studentList.stream().filter(student ->
                student.getId().equals(id)).findFirst().orElse(null);
    }
}

