package se331.helpme.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.helpme.project.dao.AdvisorDao;
import se331.helpme.project.dao.StudentDao;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.security.user.UserDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService{

    final AdvisorDao advisorDao;
    final StudentDao studentDao;
    final UserDao userDao;
    @Override
    public Integer getAdvisorsSize() {
        return advisorDao.getAdvisorSize();
    }

    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page) {
        return advisorDao.getAdvisors(pageSize, page);
    }

    @Override
    public Page<Advisor> getAdvisors(String filter, Pageable pageable) {
        return advisorDao.getAdvisors(filter,pageable);
    }

    @Override
    public List<Advisor> getAllAdvisors() {
        return advisorDao.getAdvisors(Pageable.unpaged()).getContent();
    }

    @Override
    public Advisor getAdvisor(Long id) {
        return advisorDao.getAdvisor(id);
    }

    @Override
    public Advisor getAdvisorByStudent(Long id) {
        return studentDao.getStudent(id).getAdvisor();
    }

    @Override
    public Advisor save(Advisor advisor) {
        return advisorDao.save(advisor);
    }

    @Override
    public Advisor updateDetail(Advisor advisor) {
        Advisor updateAdvisor = advisorDao.getAdvisor(advisor.getId());
        if (updateAdvisor != null) {

            updateAdvisor.setFirstName(advisor.getFirstName());
            updateAdvisor.setLastName(advisor.getLastName());
//            updateAdvisor.getUser().setDepartment(advisor.getDepartment());

            advisorDao.save(updateAdvisor);

            userDao.save(updateAdvisor.getUser());
            return updateAdvisor;
        }
        return null;
    }
}
