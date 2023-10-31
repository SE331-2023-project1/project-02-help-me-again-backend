package se331.helpme.project.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.repository.AdvisorRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AdvisorDaoDbImpl implements AdvisorDao {
    final AdvisorRepository advisorRepository;
    @Override
    public Integer getAdvisorSize() {
        return Math.toIntExact(advisorRepository.count());
    }

    @Override
    public Advisor save(Advisor advisor) {
        return advisorRepository.save(advisor);
    }

    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page) {
        return advisorRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<Advisor> getAdvisors(Pageable page) {
        return advisorRepository.findAll(page);
    }

    @Override
    public Advisor getAdvisor(Long id) {
        return advisorRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Advisor> getAdvisors(String filter, Pageable page) {
        return advisorRepository.findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrUser_UsernameIgnoreCaseContaining(filter,filter,filter,page);
    }
}