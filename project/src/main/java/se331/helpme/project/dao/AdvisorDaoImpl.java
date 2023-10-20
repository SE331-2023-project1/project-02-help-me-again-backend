package se331.helpme.project.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.helpme.project.entity.Advisor;


import java.util.ArrayList;
import java.util.List;

@Repository
public class AdvisorDaoImpl implements AdvisorDao {
    List<Advisor> advisorList;

    @PostConstruct
    public void init() {
        advisorList = new ArrayList<>();
        advisorList.add(Advisor.builder()
                .id(101L)
                .firstName("Dr. Sarah")
                .lastName("Johnson")
                .department("Psychology")
                .email("sarah.johnson@university.edu")
                .office("Building A, Room 101")
                .advisor_pic("https://randomuser.me/api/portraits/women/31.jpg")
                .build());

        advisorList.add(Advisor.builder()
                .id(102L)
                .firstName("Prof. David")
                .lastName("Smith")
                .department("Computer Science")
                .email("david.smith@university.edu")
                .office("Building B, Room 205")
                .advisor_pic("https://randomuser.me/api/portraits/men/32.jpg")
                .build());

        advisorList.add(Advisor.builder()
                .id(103L)
                .firstName("Dr. Maria")
                .lastName("Martinez")
                .department("Biology")
                .email("maria.martinez@university.edu")
                .office("Building C, Room 302")
                .advisor_pic("https://randomuser.me/api/portraits/women/33.jpg")
                .build());

        advisorList.add(Advisor.builder()
                .id(104L)
                .firstName("Prof. John")
                .lastName("Anderson")
                .department("Economics")
                .email("john.anderson@university.edu")
                .office("Building D, Room 110")
                .advisor_pic("https://randomuser.me/api/portraits/men/34.jpg")
                .build());

        advisorList.add(Advisor.builder()
                .id(105L)
                .firstName("Dr. Emil")
                .lastName("Thompson")
                .department("History")
                .email("emily.thompson@university.edu")
                .office("Building E, Room 405")
                .advisor_pic("https://randomuser.me/api/portraits/women/35.jpg")
                .build());

        advisorList.add(Advisor.builder()
                .id(106L)
                .firstName("Prof. Michael")
                .lastName("Davis")
                .department("Physics")
                .email("michael.davis@university.edu")
                .office("Building F, Room 201")
                .advisor_pic("https://randomuser.me/api/portraits/men/36.jpg")
                .build());

        advisorList.add(Advisor.builder()
                .id(107L)
                .firstName("Dr. Laura")
                .lastName("White")
                .department("Literature")
                .email("laura.white@university.edu")
                .office("Building G, Room 301")
                .advisor_pic("https://randomuser.me/api/portraits/women/37.jpg")
                .build());

        advisorList.add(Advisor.builder()
                .id(108L)
                .firstName("Prof. Jessica")
                .lastName("Martin")
                .department("PsyArt and Design")
                .email("jessica.martin@university.edu")
                .office("Building H, Room 102")
                .advisor_pic("https://randomuser.me/api/portraits/women/38.jpg")
                .build());

        advisorList.add(Advisor.builder()
                .id(109L)
                .firstName("Dr. Robert")
                .lastName("Johnson")
                .department("Chemistry")
                .email("robert.johnson@university.edu")
                .office("Building I, Room 202")
                .advisor_pic("https://randomuser.me/api/portraits/men/39.jpg")
                .build());

        advisorList.add(Advisor.builder()
                .id(110L)
                .firstName("Prof. Sarah")
                .lastName("Adams")
                .department("Mathematics")
                .email("sarah.adams@university.edu")
                .office("Building J, Room 310")
                .advisor_pic("https://randomuser.me/api/portraits/women/40.jpg")
                .build());

    }
    @Override
    public Integer getAdvisorSize() {
        return advisorList.size();
    }

    @Override
    public List<Advisor> getAdvisors(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? advisorList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return advisorList.subList(firstIndex, firstIndex+pageSize);
    }

    @Override
    public Advisor getAdvisor(Long id) {
        return  advisorList.stream().filter(advisor ->
                advisor.getId().equals(id)).findFirst().orElse(null);
    }
}