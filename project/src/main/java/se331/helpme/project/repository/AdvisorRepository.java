package se331.helpme.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.helpme.project.entity.Advisor;

import java.util.List;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    List<Advisor> findAll();

    Page<Advisor> findByFirstNameContainingIgnoreCaseOrAdvisor_ID
            (String firstName,String advisor_ID, Pageable pageable);


}

