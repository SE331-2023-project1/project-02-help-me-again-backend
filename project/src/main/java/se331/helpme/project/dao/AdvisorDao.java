package se331.helpme.project.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.helpme.project.entity.Advisor;

import java.util.Optional;

public interface AdvisorDao {

    Integer getAdvisorSize();
    Advisor save(Advisor advisor);
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);
    Page<Advisor> getAdvisors(Pageable page);
    Advisor getAdvisor(Long id);

    Page<Advisor> getAdvisors(String filter, Pageable page);

}