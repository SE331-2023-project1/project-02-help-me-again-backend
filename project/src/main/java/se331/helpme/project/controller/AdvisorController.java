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
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.service.AdvisorService;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class AdvisorController {

    final AdvisorService advisorService;


    @GetMapping("advisor")
    public ResponseEntity<?> getAdvisorLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {

        List<Advisor> output = null;
        Integer advisorSize = advisorService.getAdvisorSize();

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(advisorSize));


//        for (int i = firstIndex; i < firstIndex + perPage; i++) {
//            output.add(studentList.get(i));
//        }

        try {
            output = advisorService.getAdvisors(perPage, page);
            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {


            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);

        }
    }

    @GetMapping("advisor/{id}")
    public ResponseEntity<?> getAdvisor(@PathVariable("id") Long id) {
        Advisor output = advisorService.getAdvisor(id);

        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }



}
