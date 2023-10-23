package se331.helpme.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.service.AdvisorService;
import se331.helpme.project.util.LabMapper;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdvisorController {

    final AdvisorService advisorService;

    @GetMapping("advisor")
    public ResponseEntity<?> getAdvisorLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page,
                                             @RequestParam(value = "filter", required = false) String filter) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Advisor> pageOutput;
        if (filter == null) {
            pageOutput = advisorService.getAdvisors(perPage,page);
        }else{
            pageOutput = advisorService.getAdvisors(filter, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAdvisorDTO(pageOutput.getContent()),responseHeader, HttpStatus.OK);
    }
    @GetMapping("AllAdvisors")
    public ResponseEntity<?> getAdvisors(@RequestParam(value = "_limit", required = false) Integer perPage,
                                         @RequestParam(value = "_page", required = false) Integer page,
                                         @RequestParam(value = "filter", required = false) String filter) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Advisor> pageOutput;
        if (filter == null) {
            pageOutput = advisorService.getAdvisors(perPage,page);
        }else{
            pageOutput = advisorService.getAdvisors(filter, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(advisorService.getAllAdvisors()));
    }

    @PutMapping("updateAdvisors")
    public ResponseEntity<?> updateAdvisorDetails(@RequestBody Advisor advisor)
    {
        return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(advisorService.updateDetail(advisor)));
    }

    @GetMapping("advisors/{id}")
    public ResponseEntity<?> getAdvisor(@PathVariable("id") Long id) {
        Advisor output = advisorService.getAdvisor(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @GetMapping("advisorByStudent/{id}")
    public ResponseEntity<?> getAdvisorByStudent(@PathVariable Long id) {
        Advisor advisor = advisorService.getAdvisorByStudent(id);
        if (advisor != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(advisor));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}
