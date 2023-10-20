package se331.helpme.project.dao;

import se331.helpme.project.entity.Advisor;

import java.util.List;

public interface AdvisorDao {
    Integer getAdvisorSize();
    List<Advisor> getAdvisors(Integer pageSize, Integer page);
    Advisor getAdvisor(Long id);
}
