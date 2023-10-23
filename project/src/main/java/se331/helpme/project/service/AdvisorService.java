package se331.helpme.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.helpme.project.entity.Advisor;

import java.util.List;

public interface AdvisorService {

    Integer getAdvisorsSize();

    Page<Advisor> getAdvisors(Integer pageSize, Integer page);

    Page<Advisor> getAdvisors(String filter, Pageable pageable);

    List<Advisor> getAllAdvisors();

    Advisor getAdvisor(Long id);

    Advisor save(Advisor advisor);

    Advisor updateDetail(Advisor advisor);

    Advisor getAdvisorByStudent(Long id);
}

