package se331.helpme.project.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.entity.Announcement;
import se331.helpme.project.entity.Student;
import se331.helpme.project.repository.AdvisorRepository;
import se331.helpme.project.repository.AnnouncementRepository;
import se331.helpme.project.repository.StudentRepository;
import se331.helpme.project.security.user.Role;
import se331.helpme.project.security.user.User;
import se331.helpme.project.security.user.UserRepository;

import java.util.ArrayList;
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

//        User user1 = new User();
//        user1.setFirstname("Siriyakorn");
//        user1.setLastname("Chomhuen");
//        user1.setUsername("Baibua");
//        userRepository.save(user1);
//        Student student1 = new Student();
//        student1.setUser(user1);
//        studentRepository.save(student1);
//
//        User user2 = new User();
//        user2.setFirstname("Sasipha");
//        user2.setLastname("Tongkhan");
//        user2.setUsername("Nameeiei");
//        userRepository.save(user2);
//        Student student2 = new Student();
//        student2.setUser(user2);
//        studentRepository.save(student2);
//
//        User user3 = new User();
//        user3.setFirstname("Thanapong");
//        user3.setLastname("Happy");
//        user3.setUsername("Su");
//        userRepository.save(user3);
//        Student student3 = new Student();
//        student1.setUser(user3);
//        studentRepository.save(student3);
//
//        User user4 = new User();
//        user4.setFirstname("Emily");
//        user4.setLastname("Johnson");
//        user4.setUsername("Emily");
//        userRepository.save(user4);
//        Student student4 = new Student();
//        student4.setUser(user4);
//        studentRepository.save(student4);


        //Username and Password for each role

        //Advisors
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User userT1 = new User();
        userT1.setUsername("TT5678");
        userT1.setPassword(encoder.encode("TT5678"));
//        userT1.setFirstName("Prof. Chartchai");
//        userT1.setLastName("Doungsa-ard");
        userT1.setRoles(List.of(Role.ROLE_ADVISOR));
        userT1.setDepartment("Software Engineer");
        userT1.setAcademic("CAMT");
        userT1.setImages(Collections.singletonList("https://randomuser.me/api/portraits/men/32.jpg"));
        userRepository.save(userT1);

        Advisor advisor1 = new Advisor();
        advisor1.setFirstName("Prof. Chartchai");
        advisor1.setLastName("Doungsa-ard");
        advisor1.setUser(userT1);
        advisorRepository.save(advisor1);

        User userT2 = new User();
        userT2.setUsername("PP1234");
        userT2.setPassword(encoder.encode("PP1234"));
//        userT2.setFirstName("Prof. Tei");
//        userT2.setLastName("Pathathai");
        userT2.setRoles(List.of(Role.ROLE_ADVISOR));
        userT2.setDepartment("Software Engineer");
        userT2.setAcademic("CAMT");
        userT2.setImages(Collections.singletonList("https://randomuser.me/api/portraits/women/33.jpg"));
        userRepository.save(userT2);

        Advisor advisor2 = new Advisor();
        advisor2.setFirstName("Prof. Tei");
        advisor2.setLastName("Pathathai");
        advisor2.setUser(userT2);
        advisorRepository.save(advisor2);

        User userT3 = new User();
        userT3.setUsername("David123");
        userT3.setPassword(encoder.encode("David123"));
//        userT3.setFirstName("Prof. David");
//        userT3.setLastName("Smith");
        userT3.setRoles(List.of(Role.ROLE_ADVISOR));
        userT3.setDepartment("Software Engineer");
        userT3.setAcademic("CAMT");
        userT3.setImages(Collections.singletonList("https://randomuser.me/api/portraits/men/33.jpg"));
        userRepository.save(userT3);


        Advisor advisor3 = new Advisor();
        advisor3.setFirstName("Prof. David");
        advisor3.setLastName("Smith");
        advisor3.setUser(userT3);
        advisorRepository.save(advisor3);

        User userT4 = new User();
        userT4.setUsername("John123");
        userT4.setPassword(encoder.encode("John123"));
//        userT4.setFirstName("Prof. John");
//        userT4.setLastName("Anderson");
        userT4.setRoles(List.of(Role.ROLE_ADVISOR));
        userT4.setDepartment("Economic");
        userT4.setAcademic("ECON");
        userT4.setImages(Collections.singletonList("https://randomuser.me/api/portraits/men/34.jpg"));
        userRepository.save(userT4);


        Advisor advisor4 = new Advisor();
        advisor4.setFirstName("Prof. John");
        advisor4.setLastName("Anderson");
        advisor4.setUser(userT4);
        advisorRepository.save(advisor4);

        // Students
        User userS1 = new User();
        userS1.setUsername("642115022");
        userS1.setPassword(encoder.encode("642115022"));
//        userS1.setFirstName("Tanapong");
//        userS1.setLastName("Yamkamol");
        userS1.setRoles(List.of(Role.ROLE_STUDENT));
        userS1.setDepartment("Software Engineer");
        userS1.setImages(Collections.singletonList("https://randomuser.me/api/portraits/men/1.jpg"));
        userRepository.save(userS1);

        Student student1 = new Student();
        student1.setFirstName("Tanapong");
        student1.setLastName("Yamkamol");
        student1.setUser(userS1);
        student1.setAdvisor(advisor1);
        studentRepository.save(student1);


        User userS2 = new User();
        userS2.setUsername("642115042");
        userS2.setPassword(encoder.encode("642115042"));
//        userS2.setFirstName("Sasipha");
//        userS2.setLastName("Thonkhan");
        userS2.setRoles(List.of(Role.ROLE_STUDENT));
        userS2.setDepartment("Software Engineer");
        userS2.setImages(Collections.singletonList("https://randomuser.me/api/portraits/women/1.jpg"));
        userRepository.save(userS2);

        Student student2 = new Student();
        student2.setFirstName("Sasipha");
        student2.setLastName("Thonkhan");
        student2.setUser(userS2);
        studentRepository.save(student2);


        User userS3 = new User();
        userS3.setUsername("642115047");
        userS3.setPassword(encoder.encode("642115047"));
//        userS3.setFirstName("Siriyakorn");
//        userS3.setLastName("Chomchuen");
        userS3.setRoles(List.of(Role.ROLE_STUDENT));
        userS3.setDepartment("Software Engineer");
        userS3.setImages(Collections.singletonList("https://randomuser.me/api/portraits/women/2.jpg"));
        userRepository.save(userS3);

        Student student3 = new Student();
        student3.setFirstName("Siriyakorn");
        student3.setLastName("Chomchuen");
        student3.setUser(userS3);
        studentRepository.save(student3);

        User userS4 = new User();
        userS4.setUsername("Emily123");
        userS4.setPassword(encoder.encode("Emily123"));
//        userS4.setFirstName("Emily");
//        userS4.setLastName("Johnson");
        userS4.setRoles(List.of(Role.ROLE_STUDENT));
        userS4.setDepartment("Fine Art");
        userS4.setImages(Collections.singletonList("https://randomuser.me/api/portraits/women/4.jpg"));
        userRepository.save(userS4);

        Student student4 = new Student();
        student4.setFirstName("Emily");
        student4.setLastName("Johnson");
        student4.setUser(userS4);
        studentRepository.save(student4);

        User userS5 = new User();
        userS5.setUsername("Ethan123");
        userS5.setPassword(encoder.encode("Ethan123"));
//        userS5.setFirstName("Ethan");
//        userS5.setLastName("Smith");
        userS5.setRoles(List.of(Role.ROLE_STUDENT));
        userS5.setDepartment("Fine Art");
        userS5.setImages(Collections.singletonList("https://randomuser.me/api/portraits/men/5.jpg"));
        userRepository.save(userS5);

        Student student5 = new Student();
        student5.setFirstName("Ethan");
        student5.setLastName("Smith");
        student5.setUser(userS5);
        studentRepository.save(student5);

        User userS6 = new User();
        userS6.setUsername("Olivia123");
        userS6.setPassword(encoder.encode("Olivia123"));
//        userS6.setFirstName("Olivia");
//        userS6.setLastName("Martinez");
        userS6.setRoles(List.of(Role.ROLE_STUDENT));
        userS6.setDepartment("Fine Art");
        userS6.setImages(Collections.singletonList("https://randomuser.me/api/portraits/women/6.jpg"));
        userRepository.save(userS6);

        Student student6 = new Student();
        student6.setFirstName("Olivia");
        student6.setLastName("Martinez");
        student6.setUser(userS6);
        studentRepository.save(student6);

        User userS7 = new User();
        userS7.setUsername("Ava123");
        userS7.setPassword(encoder.encode("Ava123"));
//        userS7.setFirstName("Ava");
//        userS7.setLastName("Thompson");
        userS7.setRoles(List.of(Role.ROLE_STUDENT));
        userS7.setDepartment("History");
        userS7.setImages(Collections.singletonList("https://randomuser.me/api/portraits/women/7.jpg"));
        userRepository.save(userS7);

        Student student7 = new Student();
        student7.setFirstName("Ava");
        student7.setLastName("Thompson");
        student7.setUser(userS7);
        studentRepository.save(student7);

        User userS8 = new User();
        userS8.setUsername("Noah123");
        userS8.setPassword(encoder.encode("Noah123"));
//        userS8.setFirstName("Noah");
//        userS8.setLastName("Williams");
        userS8.setRoles(List.of(Role.ROLE_STUDENT));
        userS8.setDepartment("Chemistry");
        userS8.setImages(Collections.singletonList("https://randomuser.me/api/portraits/men/8.jpg"));
        userRepository.save(userS8);

        Student student8 = new Student();
        student8.setFirstName("Noah");
        student8.setLastName("Williams");
        student8.setUser(userS8);
        studentRepository.save(student8);

        User userS9 = new User();
        userS9.setUsername("Sophia123");
        userS9.setPassword(encoder.encode("Sophia123"));
//        userS9.setFirstName("Sophia");
//        userS9.setLastName("Brown");
        userS9.setRoles(List.of(Role.ROLE_STUDENT));
        userS9.setDepartment("Mathematics");
        userS9.setImages(Collections.singletonList("https://randomuser.me/api/portraits/women/9.jpg"));
        userRepository.save(userS9);

        Student student9 = new Student();
        student9.setFirstName("Sophia");
        student9.setLastName("Brown");
        student9.setUser(userS9);
        studentRepository.save(student9);

        User userS10 = new User();
        userS10.setUsername("Jackson123");
        userS10.setPassword(encoder.encode("Jackson123"));
//        userS10.setFirstName("Jackson");
//        userS10.setLastName("Davis");
        userS10.setRoles(List.of(Role.ROLE_STUDENT));
        userS10.setDepartment("Mathematics");
        userS10.setImages(Collections.singletonList("https://randomuser.me/api/portraits/men/10.jpg"));
        userRepository.save(userS10);

        Student student10 = new Student();
        student10.setFirstName("Jackson");
        student10.setLastName("Davis");
        student10.setUser(userS10);
        studentRepository.save(student10);

        User userS11 = new User();
        userS11.setUsername("Isabella123");
        userS11.setPassword(encoder.encode("Isabella123"));
//        userS11.setFirstName("Isabella");
//        userS11.setLastName("Rodriguez");
        userS11.setRoles(List.of(Role.ROLE_STUDENT));
        userS11.setDepartment("Psychology");
        userS11.setImages(Collections.singletonList("https://randomuser.me/api/portraits/women/11.jpg"));
        userRepository.save(userS11);

        Student student11 = new Student();
        student11.setFirstName("Isabella");
        student11.setLastName("Rodriguez");
        student11.setUser(userS11);
        studentRepository.save(student11);

        User userS12 = new User();
        userS12.setUsername("Aiden123");
        userS12.setPassword(encoder.encode("Aiden123"));
//        userS12.setFirstName("Aiden");
//        userS12.setLastName("Wilson");
        userS12.setRoles(List.of(Role.ROLE_STUDENT));
        userS12.setDepartment("History");
        userS12.setImages(Collections.singletonList("https://randomuser.me/api/portraits/men/12.jpg"));
        userRepository.save(userS12);

        Student student12 = new Student();
        student12.setFirstName("Aiden");
        student12.setLastName("Wilson");
        student12.setUser(userS12);
        studentRepository.save(student12);


        //Set advisor and students
        advisor1.setUser(userT1);
        advisor1.getStudentList().add(student1);
        advisor1.getStudentList().add(student2);
        advisor1.getStudentList().add(student9);
        student1.setUser(userS1);
        student1.setAdvisor(advisor1);
        student2.setUser(userS2);
        student2.setAdvisor(advisor1);
        student9.setUser(userS9);
        student9.setAdvisor(advisor1);

        advisor2.setUser(userT2);
        advisor2.getStudentList().add(student3);
        advisor2.getStudentList().add(student4);
        advisor1.getStudentList().add(student10);
        student3.setUser(userS3);
        student3.setAdvisor(advisor2);
        student4.setUser(userS4);
        student4.setAdvisor(advisor2);
        student10.setUser(userS10);
        student10.setAdvisor(advisor2);

        advisor3.setUser(userT3);
        advisor3.getStudentList().add(student5);
        advisor3.getStudentList().add(student6);
        advisor1.getStudentList().add(student11);
        student5.setUser(userS5);
        student5.setAdvisor(advisor3);
        student6.setUser(userS6);
        student6.setAdvisor(advisor3);
        student11.setUser(userS11);
        student11.setAdvisor(advisor3);

        advisor4.setUser(userT4);
        advisor4.getStudentList().add(student7);
        advisor4.getStudentList().add(student8);
        advisor1.getStudentList().add(student12);
        student7.setUser(userS7);
        student7.setAdvisor(advisor4);
        student8.setUser(userS8);
        student8.setAdvisor(advisor4);
        student12.setUser(userS12);
        student12.setAdvisor(advisor4);




        User admin;
        admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
//                .firstName("admin")
//                .lastName("admin")
                .email("admin@cmu.com")
                .roles(List.of(Role.ROLE_ADMIN))
                .build();
        userRepository.save(admin);

        List<String> files = new ArrayList<>();

        files.add("");
        files.add("https://img.freepik.com/free-photo/portrait-student-boy_23-2147668972.jpg?w=2000");

        Announcement announcement;
        announcement = Announcement.builder()
                .title("Project Compo")
                .description("Project deadline is today.")
                .files(files)
                .build();
        announcementRepository.save(announcement);

        List<String> files2 = new ArrayList<>();
        files2.add("https://forms.gle/GMC97xXxN55ZPnyw9");

        Announcement announcement2;
        announcement2 = Announcement.builder()
                .title("Satisfaction Survey")
                .description("This is survey of co-working space.")
                .files(files2)
                .build();
        announcementRepository.save(announcement2);

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

