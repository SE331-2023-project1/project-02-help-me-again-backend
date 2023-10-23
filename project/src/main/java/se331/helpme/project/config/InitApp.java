package se331.helpme.project.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.entity.Student;
import se331.helpme.project.repository.AdvisorRepository;
import se331.helpme.project.repository.StudentRepository;

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

        Advisor advisor1,advisor2, advisor3, advisor4, advisor5, advisor6, advisor7, advisor8, advisor9, advisor10;
        advisor1 = advisorRepository.save(Advisor.builder()
                .id(101L)
                .firstName("Dr. Sarah")
                .lastName("Johnson")
                .department("Psychology")
                .email("sarah.johnson@university.edu")
                .office("Building A, Room 101")
                .advisor_pic(List.of("https://randomuser.me/api/portraits/women/31.jpg"))
                .build());

        advisor2 = advisorRepository.save(Advisor.builder()
                .id(102L)
                .firstName("Prof. David")
                .lastName("Smith")
                .department("Computer Science")
                .email("david.smith@university.edu")
                .office("Building B, Room 205")
                .advisor_pic(List.of("https://randomuser.me/api/portraits/men/32.jpg"))
                .build());

        advisor3 = advisorRepository.save(Advisor.builder()
                .id(103L)
                .firstName("Dr. Maria")
                .lastName("Martinez")
                .department("Biology")
                .email("maria.martinez@university.edu")
                .office("Building C, Room 302")
                .advisor_pic(List.of("https://randomuser.me/api/portraits/women/33.jpg"))
                .build());

        advisor4 = advisorRepository.save(Advisor.builder()
                .id(104L)
                .firstName("Prof. John")
                .lastName("Anderson")
                .department("Economics")
                .email("john.anderson@university.edu")
                .office("Building D, Room 110")
                .advisor_pic(List.of("https://randomuser.me/api/portraits/men/34.jpg"))
                .build());

        advisor5 = advisorRepository.save(Advisor.builder()
                .id(105L)
                .firstName("Dr. Emil")
                .lastName("Thompson")
                .department("History")
                .email("emily.thompson@university.edu")
                .office("Building E, Room 405")
                .advisor_pic(List.of("https://randomuser.me/api/portraits/women/35.jpg"))
                .build());

        advisor6 = advisorRepository.save(Advisor.builder()
                .id(106L)
                .firstName("Prof. Michael")
                .lastName("Davis")
                .department("Physics")
                .email("michael.davis@university.edu")
                .office("Building F, Room 201")
                .advisor_pic(List.of("https://randomuser.me/api/portraits/men/36.jpg"))
                .build());

        advisor7 = advisorRepository.save(Advisor.builder()
                .id(107L)
                .firstName("Dr. Laura")
                .lastName("White")
                .department("Literature")
                .email("laura.white@university.edu")
                .office("Building G, Room 301")
                .advisor_pic(List.of("https://randomuser.me/api/portraits/women/37.jpg"))
                .build());

        advisor8 = advisorRepository.save(Advisor.builder()
                .id(108L)
                .firstName("Prof. Jessica")
                .lastName("Martin")
                .department("PsyArt and Design")
                .email("jessica.martin@university.edu")
                .office("Building H, Room 102")
                .advisor_pic(List.of("https://randomuser.me/api/portraits/women/38.jpg"))
                .build());

        advisor9 = advisorRepository.save(Advisor.builder()
                .id(109L)
                .firstName("Dr. Robert")
                .lastName("Johnson")
                .department("Chemistry")
                .email("robert.johnson@university.edu")
                .office("Building I, Room 202")
                .advisor_pic(List.of("https://randomuser.me/api/portraits/men/39.jpg"))
                .build());

        advisor10 = advisorRepository.save(Advisor.builder()
                .id(110L)
                .firstName("Prof. Sarah")
                .lastName("Adams")
                .department("Mathematics")
                .email("sarah.adams@university.edu")
                .office("Building J, Room 310")
                .advisor_pic(List.of("https://randomuser.me/api/portraits/women/40.jpg"))
                .build());

        Student student;

        student = studentRepository.save(Student.builder()
                .id(1L)
                .firstName("Emily")
                .lastName("Johnson")
                .student_ID("STID-1001")
                .registered("Mathematics, English Literature, History, Physics, Spanish")
                .stu_pic(List.of("https://randomuser.me/api/portraits/women/1.jpg"))
                .build());
        student.setAdvisor(advisor1);
        advisor1.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(2L)
                .firstName("Ethan")
                .lastName("Smith")
                .student_ID("STID-1002")
                .registered("Physics, Computer Science, Spanish, Biology, Chemistry")
                .stu_pic(List.of("https://randomuser.me/api/portraits/men/2.jpg"))
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(3L)
                .firstName("Olivia")
                .lastName("Martinez")
                .student_ID("STID-1003")
                .registered("Biology, Chemistry, French, Geography, Art")
                .stu_pic(List.of("https://randomuser.me/api/portraits/women/3.jpg"))
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(4L)
                .firstName("Liam")
                .lastName("Anderson")
                .student_ID("STID-1004")
                .registered("Economics, Mathematics, Psychology, English Literature, Music")
                .stu_pic(List.of("https://randomuser.me/api/portraits/men/4.jpg"))
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(5L)
                .firstName("Ava")
                .lastName("Thompson")
                .student_ID("STID-1005")
                .registered("Art, Music, Physical Education, Spanish, History")
                .stu_pic(List.of("https://randomuser.me/api/portraits/women/5.jpg"))
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(6L)
                .firstName("Noah")
                .lastName("Williams")
                .student_ID("STID-1006")
                .registered("English Literature, History, Geography, Chemistry, Biology")
                .stu_pic(List.of("https://randomuser.me/api/portraits/men/6.jpg"))
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(7L)
                .firstName("Sophia")
                .lastName("Brown")
                .student_ID("STID-1007")
                .registered("Mathematics, Physics, Biology, Psychology, Computer Science")
                .stu_pic(List.of("https://randomuser.me/api/portraits/women/7.jpg"))
                .build());
        student.setAdvisor(advisor7);
        advisor7.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(8L)
                .firstName("Jackson")
                .lastName("Davis")
                .student_ID("STID-1008")
                .registered("Chemistry, Computer Science, English, Geography, Economics")
                .stu_pic(List.of("https://randomuser.me/api/portraits/men/8.jpg"))
                .build());
        student.setAdvisor(advisor8);
        advisor8.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(9L)
                .firstName("Isabella")
                .lastName("Rodriguez")
                .student_ID("STID-1009")
                .registered("Spanish, Art, Psychology, Music, French")
                .stu_pic(List.of("https://randomuser.me/api/portraits/women/9.jpg"))
                .build());
        student.setAdvisor(advisor9);
        advisor9.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(10L)
                .firstName("Aiden")
                .lastName("Wilson")
                .student_ID("STID-1010")
                .registered("Geography, History, Economics, Mathematics, English Literature")
                .stu_pic(List.of("https://randomuser.me/api/portraits/men/10.jpg"))
                .build());
        student.setAdvisor(advisor10);
        advisor10.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(11L)
                .firstName("Mia")
                .lastName("Taylor")
                .student_ID("STID-1011")
                .registered("Biology, Chemistry, Music, Spanish, Physical Education")
                .stu_pic(List.of("https://randomuser.me/api/portraits/women/11.jpg"))
                .build());
        student.setAdvisor(advisor1);
        advisor1.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(12L)
                .firstName("Lucas")
                .lastName("Moore")
                .student_ID("STID-1012")
                .registered("Mathematics, Physics, Computer Science, History, Chemistry")
                .stu_pic(List.of("https://randomuser.me/api/portraits/men/12.jpg"))
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(13L)
                .firstName("Harper")
                .lastName("Garcia")
                .student_ID("STID-1013")
                .registered("English Literature, History, French, Geography, Art")
                .stu_pic(List.of("https://randomuser.me/api/portraits/women/13.jpg"))
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(14L)
                .firstName("Benjamin")
                .lastName("Jackson")
                .student_ID("STID-1014")
                .registered("Economics, Psychology, Spanish, Music, Biology")
                .stu_pic(List.of("https://randomuser.me/api/portraits/men/14.jpg"))
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(15L)
                .firstName("Amelia")
                .lastName("Lee")
                .student_ID("STID-1015")
                .registered("Geography, Art, Physical Education, English Literature, Chemistry")
                .stu_pic(List.of("https://randomuser.me/api/portraits/women/15.jpg"))
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(16L)
                .firstName("Henry")
                .lastName("Harris")
                .student_ID("STID-1016")
                .registered("Music, English Literature, Mathematics, Physics, Psychology")
                .stu_pic(List.of("https://randomuser.me/api/portraits/men/16.jpg"))
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(17L)
                .firstName("Ella")
                .lastName("Clark")
                .student_ID("STID-1017")
                .registered("Chemistry, Biology, Spanish, Computer Science, Economics")
                .stu_pic(List.of("https://randomuser.me/api/portraits/women/17.jpg"))
                .build());
        student.setAdvisor(advisor7);
        advisor7.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(18L)
                .firstName("Alexander")
                .lastName("White")
                .student_ID("STID-1018")
                .registered("Physics, Computer Science, Geography, History, French")
                .stu_pic(List.of("https://randomuser.me/api/portraits/men/18.jpg"))
                .build());
        student.setAdvisor(advisor8);
        advisor8.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .id(19L)
                .firstName("Charlotte")
                .lastName("Hall")
                .student_ID("STID-1019")
                .registered("History, Economics, Psychology, Biology, Music")
                .stu_pic(List.of("https://randomuser.me/api/portraits/women/19.jpg"))
                .build());
        student.setAdvisor(advisor9);
        advisor9.getStudentList().add(student);

    }
}

