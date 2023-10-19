package se331.helpme.project.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.helpme.project.controller.StudentController;

import jakarta.annotation.PostConstruct;
import se331.helpme.project.entity.Event;
import se331.helpme.project.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    List<Student> studentList;

    @PostConstruct
    public void init() {
        studentList = new ArrayList<>();
        studentList.add(Student.builder()
                .id(1L)
                .FirstName("Emily")
                .LastName("Johnson")
                .Student_ID("STID-1001")
                .registered("Mathematics, English Literature, History, Physics, Spanish")
                .advisor(101L)
                .stu_pic("https://randomuser.me/api/portraits/women/1.jpg")
                .build());

        studentList.add(Student.builder()
                .id(2L)
                .FirstName("Ethan")
                .LastName("Smith")
                .Student_ID("STID-1002")
                .registered("Physics, Computer Science, Spanish, Biology, Chemistry")
                .advisor(102L)
                .stu_pic("https://randomuser.me/api/portraits/men/2.jpg")
                .build());
    }

    @GetMapping("StudentView")
    public ResponseEntity<?> getStudentLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {

        perPage = perPage == null ? studentList.size() : perPage;
        page = page == null ? 1 : page;
        Integer firstIndex = (page - 1) * perPage;
        List<Student> output = new ArrayList<>();

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(studentList.size()));


        for (int i = firstIndex; i < firstIndex + perPage; i++) {
            output.add(studentList.get(i));
        }

        try {
            for (int i = firstIndex; i < firstIndex + perPage; i++) {
                output.add(studentList.get(i));
            }
            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {


            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);

        }
    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id) {
        Student output = null;
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                output = student;
                break;
            }
        }
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }



}


