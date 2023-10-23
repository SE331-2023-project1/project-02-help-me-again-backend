package se331.helpme.project.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.helpme.project.entity.Advisor;

import java.util.Optional;

public interface AdvisorDao {
    Integer getAdvisorSize();
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);

    Advisor getAdvisorById(Long id);

    Advisor save(Advisor advisor);
    Optional<Advisor> findById(Long id);

    Page<Advisor> getAdvisor(String firstName, Pageable page);
}