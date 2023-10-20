package se331.helpme.project.controller;

import lombok.RequiredArgsConstructor;
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
import se331.helpme.project.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class StudentController {

    final StudentService studentService;


    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {

        List<Student> output = null;
        Integer studentSize = studentService.getStudentSize();

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(studentSize));


//        for (int i = firstIndex; i < firstIndex + perPage; i++) {
//            output.add(studentList.get(i));
//        }

        try {
            output = studentService.getStudents(perPage, page);
            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {


            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);

        }
    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id) {
        Student output = studentService.getStudent(id);

        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }



}

