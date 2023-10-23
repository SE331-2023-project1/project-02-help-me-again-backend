package se331.helpme.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.helpme.project.entity.Advisor;

import java.util.List;

public interface AdvisorService {
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);
    Advisor getAdvisor(Long id);
    Advisor getAdvisorById (Long id);
    Advisor save(Advisor advisor);
    Page<Advisor> getAdvisor(String firstName, Pageable page);
}
