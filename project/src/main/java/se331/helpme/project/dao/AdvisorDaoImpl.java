package se331.helpme.project.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.repository.AdvisorRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdvisorDaoImpl implements AdvisorDao{
    final AdvisorRepository advisorRepository;
    @Override
    public Integer getAdvisorSize(){
        return Math.toIntExact(advisorRepository.count());
    }
    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page){
        long totalEvents =advisorRepository.count();
        pageSize = pageSize == null ? (int) totalEvents : pageSize;
        page = page == null ? 0 : page - 1;
        return advisorRepository.findAll(PageRequest.of(page, pageSize));
    }
    @Override
    public Advisor getAdvisorById(Long id){
        return advisorRepository.findById(id).orElse(null);
    }
    @Override
    public Advisor save(Advisor advisor){
        return advisorRepository.save(advisor);
    }
    @Override
    public Optional<Advisor> findById(Long id){
        return advisorRepository.findById(id);
    }

    @Override
    public Page<Advisor> getAdvisor(String firstName, Pageable page){
        return advisorRepository.findByFirstNameContainingIgnoreCaseOrAdvisor_ID(firstName, firstName ,page);
    }

}