package se331.helpme.project.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.entity.Student;
import se331.helpme.project.repository.AdvisorRepository;
import se331.helpme.project.repository.AnnouncementRepository;
import se331.helpme.project.repository.StudentRepository;
import se331.helpme.project.security.user.Role;
import se331.helpme.project.security.user.User;
import se331.helpme.project.security.user.UserRepository;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;
    final UserRepository userRepository;
    final AnnouncementRepository announcementRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

//        Advisor advisor1,advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, advisor10;

        User user1 = new User();
        user1.setFirstname("Siriyakorn");
        user1.setLastname("CHomhuen");
        user1.setUsername("Baibua");
        userRepository.save(user1);
        Advisor veevi1 = new Advisor();
        veevi1.setUser(user1);
        advisorRepository.save(veevi1);

        User user2 = new User();
        user2.setFirstname("Sasipha");
        user2.setLastname("Tongkhan");
        user2.setUsername("Nameeiei");
        userRepository.save(user2);
        Advisor veevi2 = new Advisor();
        veevi2.setUser(user2);
        advisorRepository.save(veevi2);

        User user3 = new User();
        user3.setFirstname("Thanapong");
        user3.setLastname("Happy");
        user3.setUsername("Su");
        userRepository.save(user3);
        Student veevi3 = new Student();
        veevi3.setUser(user3);
        studentRepository.save(veevi3);

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User userT1 = new User();
        userT1.setUsername("TT");
        userT1.setPassword(encoder.encode("TT"));
        userT1.setFirstname("Chartchai");
        userT1.setLastname("Doungsa-ard");
        userT1.setRoles(List.of(Role.ROLE_ADVISOR));
        userT1.setDepartment("Software Engineer");
        userT1.setAcademic("CAMT");
        userT1.setImages(Collections.singletonList("https://gsep.pepperdine.edu/blog/images/how-much-could-a-masters-degree-increase-your-teaching-salary.png"));
        userRepository.save(userT1);

        Advisor advisor1 = new Advisor();
        advisor1.setUser(userT1);
        advisorRepository.save(advisor1);

        User userT2 = new User();
        userT2.setUsername("PP");
        userT2.setPassword(encoder.encode("PP"));
        userT2.setFirstname("Tei");
        userT2.setLastname("Pathathai");
        userT2.setRoles(List.of(Role.ROLE_ADVISOR));
        userT2.setDepartment("Software Engineer");
        userT2.setAcademic("CAMT");
        userT2.setImages(Collections.singletonList("https://www.hindustantimes.com/ht-img/img/2023/09/02/1600x900/teachers_day_1693652054152_1693652065719.jpg"));
        userRepository.save(userT2);

        Advisor advisor2 = new Advisor();
        advisor2.setUser(userT2);
        advisorRepository.save(advisor2);


        User userS1 = new User();
        userS1.setUsername("642115022");
        userS1.setPassword(encoder.encode("642115022"));
        userS1.setFirstname("Tanapong");
        userS1.setLastname("Yamkamol");
        userS1.setRoles(List.of(Role.ROLE_STUDENT));
        userS1.setDepartment("Software Engineer");
        userS1.setImages(Collections.singletonList("https://study.uq.edu.au/sites/default/files/styles/hero_xl/public/2022-06/admissions-hero.jpg?h=2087dbb7&itok=Tx6Xi1cU"));
        userRepository.save(userS1);

        Student student1 = new Student();
        student1.setUser(userS1);
        student1.setAdvisor(advisor1);
        studentRepository.save(student1);


        User userS2 = new User();
        userS2.setUsername("642115042");
        userS2.setPassword(encoder.encode("642115042"));
        userS2.setFirstname("Sasipha");
        userS2.setLastname("Thonkhan");
        userS2.setRoles(List.of(Role.ROLE_STUDENT));
        userS2.setDepartment("Software Engineer");
        userS2.setImages(Collections.singletonList("https://img.freepik.com/free-photo/young-woman-attend-courses-girl-student-studying-holding-notebooks-showing-thumb-up-approval-recommending-company-standing-blue-background_1258-70145.jpg"));
        userRepository.save(userS2);

        Student student2 = new Student();
        student2.setUser(userS2);
        studentRepository.save(student2);


        User userS3 = new User();
        userS3.setUsername("642115047");
        userS3.setPassword(encoder.encode("642115047"));
        userS3.setFirstname("Siriyakorn");
        userS3.setLastname("Chomchuen");
        userS3.setRoles(List.of(Role.ROLE_STUDENT));
        userS3.setDepartment("Software Engineer");
        userS3.setImages(Collections.singletonList("https://vidusetha.lk/wp-content/uploads/2017/01/uni-student.jpg"));
        userRepository.save(userS3);

        Student student3 = new Student();
        student3.setUser(userS3);
        studentRepository.save(student3);

        advisor1.setUser(userT1);
        advisor1.getStudentList().add(student1);
        advisor1.getStudentList().add(student2);
        student1.setUser(userS1);
        student1.setAdvisor(advisor1);
        student2.setUser(userS2);
        student2.setAdvisor(advisor1);

        advisor2.setUser(userT2);
        advisor2.getStudentList().add(student3);
        student3.setUser(userS3);
        student3.setAdvisor(advisor2);

//
//        advisor2 = advisorRepository.save(Advisor.builder()
//                .id(102L)
//                .name("Prof. David")
//                .surname("Smith")
//                .department("Computer Science")
//                .office("Building B, Room 205")
//                .advisor_pic("https://randomuser.me/api/portraits/men/32.jpg")
//                .build());
//
//        advisor3 = advisorRepository.save(Advisor.builder()
//                .id(103L)
//                .name("Dr. Maria")
//                .surname("Martinez")
//                .department("Biology")
//                .office("Building C, Room 302")
//                .advisor_pic("https://randomuser.me/api/portraits/women/33.jpg")
//                .build());
//
//        advisor4 = advisorRepository.save(Advisor.builder()
//                .id(104L)
//                .name("Prof. John")
//                .surname("Anderson")
//                .department("Economics")
//                .office("Building D, Room 110")
//                .advisor_pic("https://randomuser.me/api/portraits/men/34.jpg")
//                .build());
//
//        advisor5 = advisorRepository.save(Advisor.builder()
//                .id(105L)
//                .name("Dr. Emil")
//                .surname("Thompson")
//                .department("History")
//                .office("Building E, Room 405")
//                .advisor_pic("https://randomuser.me/api/portraits/women/35.jpg")
//                .build());
//
//        advisor6 = advisorRepository.save(Advisor.builder()
//                .id(106L)
//                .name("Prof. Michael")
//                .surname("Davis")
//                .department("Physics")
//                .office("Building F, Room 201")
//                .advisor_pic("https://randomuser.me/api/portraits/men/36.jpg")
//                .build());
//
//        advisor7 = advisorRepository.save(Advisor.builder()
//                .id(107L)
//                .name("Dr. Laura")
//                .surname("White")
//                .department("Literature")
//                .office("Building G, Room 301")
//                .advisor_pic("https://randomuser.me/api/portraits/women/37.jpg")
//                .build());
//
//        advisor8 = advisorRepository.save(Advisor.builder()
//                .id(108L)
//                .name("Prof. Jessica")
//                .surname("Martin")
//                .department("PsyArt and Design")
//                .office("Building H, Room 102")
//                .advisor_pic("https://randomuser.me/api/portraits/women/38.jpg")
//                .build());
//
//        advisor9 = advisorRepository.save(Advisor.builder()
//                .id(109L)
//                .name("Dr. Robert")
//                .surname("Johnson")
//                .department("Chemistry")
//                .office("Building I, Room 202")
//                .advisor_pic("https://randomuser.me/api/portraits/men/39.jpg")
//                .build());
//
//        advisor10 = advisorRepository.save(Advisor.builder()
//                .id(110L)
//                .name("Prof. Sarah")
//                .surname("Adams")
//                .department("Mathematics")
//                .office("Building J, Room 310")
//                .advisor_pic("https://randomuser.me/api/portraits/women/40.jpg")
//                .build());
//
//        Student student;
//
//        student = studentRepository.save(Student.builder()
//                .id(1L)
//                .name("Emily")
//                .surname("Johnson")
//                .images(List.of("https://randomuser.me/api/portraits/women/1.jpg"))
//                .build());
//        student.setAdvisor(advisor1);
//        advisor1.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(2L)
//                .name("Ethan")
//                .surname("Smith")
//                .images(List.of("https://randomuser.me/api/portraits/men/2.jpg"))
//                .build());
//        student.setAdvisor(advisor2);
//        advisor2.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(3L)
//                .name("Olivia")
//                .surname("Martinez")
//                .images(List.of("https://randomuser.me/api/portraits/women/3.jpg"))
//                .build());
//        student.setAdvisor(advisor3);
//        advisor3.getStudentList().add(student);

//        student = studentRepository.save(Student.builder()
//                .id(4L)
//                .firstName("Liam")
//                .lastName("Anderson")
//                .student_ID("STID-1004")
//                .registered("Economics, Mathematics, Psychology, English Literature, Music")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/men/4.jpg"))
//                .build());
//        student.setAdvisor(advisor4);
//        advisor4.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(5L)
//                .firstName("Ava")
//                .lastName("Thompson")
//                .student_ID("STID-1005")
//                .registered("Art, Music, Physical Education, Spanish, History")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/women/5.jpg"))
//                .build());
//        student.setAdvisor(advisor5);
//        advisor5.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(6L)
//                .firstName("Noah")
//                .lastName("Williams")
//                .student_ID("STID-1006")
//                .registered("English Literature, History, Geography, Chemistry, Biology")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/men/6.jpg"))
//                .build());
//        student.setAdvisor(advisor6);
//        advisor6.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(7L)
//                .firstName("Sophia")
//                .lastName("Brown")
//                .student_ID("STID-1007")
//                .registered("Mathematics, Physics, Biology, Psychology, Computer Science")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/women/7.jpg"))
//                .build());
//        student.setAdvisor(advisor7);
//        advisor7.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(8L)
//                .firstName("Jackson")
//                .lastName("Davis")
//                .student_ID("STID-1008")
//                .registered("Chemistry, Computer Science, English, Geography, Economics")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/men/8.jpg"))
//                .build());
//        student.setAdvisor(advisor8);
//        advisor8.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(9L)
//                .firstName("Isabella")
//                .lastName("Rodriguez")
//                .student_ID("STID-1009")
//                .registered("Spanish, Art, Psychology, Music, French")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/women/9.jpg"))
//                .build());
//        student.setAdvisor(advisor9);
//        advisor9.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(10L)
//                .firstName("Aiden")
//                .lastName("Wilson")
//                .student_ID("STID-1010")
//                .registered("Geography, History, Economics, Mathematics, English Literature")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/men/10.jpg"))
//                .build());
//        student.setAdvisor(advisor10);
//        advisor10.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(11L)
//                .firstName("Mia")
//                .lastName("Taylor")
//                .student_ID("STID-1011")
//                .registered("Biology, Chemistry, Music, Spanish, Physical Education")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/women/11.jpg"))
//                .build());
//        student.setAdvisor(advisor1);
//        advisor1.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(12L)
//                .firstName("Lucas")
//                .lastName("Moore")
//                .student_ID("STID-1012")
//                .registered("Mathematics, Physics, Computer Science, History, Chemistry")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/men/12.jpg"))
//                .build());
//        student.setAdvisor(advisor2);
//        advisor2.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(13L)
//                .firstName("Harper")
//                .lastName("Garcia")
//                .student_ID("STID-1013")
//                .registered("English Literature, History, French, Geography, Art")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/women/13.jpg"))
//                .build());
//        student.setAdvisor(advisor3);
//        advisor3.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(14L)
//                .firstName("Benjamin")
//                .lastName("Jackson")
//                .student_ID("STID-1014")
//                .registered("Economics, Psychology, Spanish, Music, Biology")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/men/14.jpg"))
//                .build());
//        student.setAdvisor(advisor4);
//        advisor4.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(15L)
//                .firstName("Amelia")
//                .lastName("Lee")
//                .student_ID("STID-1015")
//                .registered("Geography, Art, Physical Education, English Literature, Chemistry")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/women/15.jpg"))
//                .build());
//        student.setAdvisor(advisor5);
//        advisor5.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(16L)
//                .firstName("Henry")
//                .lastName("Harris")
//                .student_ID("STID-1016")
//                .registered("Music, English Literature, Mathematics, Physics, Psychology")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/men/16.jpg"))
//                .build());
//        student.setAdvisor(advisor6);
//        advisor6.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(17L)
//                .firstName("Ella")
//                .lastName("Clark")
//                .student_ID("STID-1017")
//                .registered("Chemistry, Biology, Spanish, Computer Science, Economics")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/women/17.jpg"))
//                .build());
//        student.setAdvisor(advisor7);
//        advisor7.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(18L)
//                .firstName("Alexander")
//                .lastName("White")
//                .student_ID("STID-1018")
//                .registered("Physics, Computer Science, Geography, History, French")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/men/18.jpg"))
//                .build());
//        student.setAdvisor(advisor8);
//        advisor8.getStudentList().add(student);
//
//        student = studentRepository.save(Student.builder()
//                .id(19L)
//                .firstName("Charlotte")
//                .lastName("Hall")
//                .student_ID("STID-1019")
//                .registered("History, Economics, Psychology, Biology, Music")
//                .stu_pic(List.of("https://randomuser.me/api/portraits/women/19.jpg"))
//                .build());
//        student.setAdvisor(advisor9);
//        advisor9.getStudentList().add(student);

    }
}

