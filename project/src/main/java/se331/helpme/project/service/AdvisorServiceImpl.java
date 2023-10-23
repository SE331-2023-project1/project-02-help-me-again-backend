package se331.helpme.project.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.helpme.project.dao.AdvisorDao;
import se331.helpme.project.entity.Advisor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService {
    final AdvisorDao advisorDao;

    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page){
        return advisorDao.getAdvisors(pageSize,page);
    }
    @Override
    public Advisor getAdvisor(Long id){
        return advisorDao.getAdvisorById(id);
    }

    @Override
    public Advisor getAdvisorById(Long id){
        return advisorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Advisor save(Advisor advisor){
        return advisorDao.save(advisor);
    }

    @Override
    public  Page<Advisor> getAdvisor(String firstName, Pageable page){
        return  advisorDao.getAdvisor(firstName, page);
    }
}
