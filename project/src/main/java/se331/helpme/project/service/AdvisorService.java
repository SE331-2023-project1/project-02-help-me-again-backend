package se331.helpme.project.service;

import se331.helpme.project.entity.Advisor;

import java.util.List;

public interface AdvisorService {
    Integer getAdvisorSize();
    List<Advisor> getAdvisors(Integer pageSize, Integer page);
    Advisor getAdvisor(Long id);
}
