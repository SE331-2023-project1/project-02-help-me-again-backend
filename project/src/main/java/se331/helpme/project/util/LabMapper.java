package se331.helpme.project.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.helpme.project.dto.AdvisorDTO;
import se331.helpme.project.dto.OwnAdvisorDTO;
import se331.helpme.project.dto.OwnStudentDTO;
import se331.helpme.project.dto.StudentDTO;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.entity.Student;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    StudentDTO getStudentDto(Student student);
    List<StudentDTO> getStudentDto(List<Student> students);
    AdvisorDTO getAdvisorDto(Advisor advisor);
    List<AdvisorDTO> getAdvisorDto(List<Advisor> advisors);
    OwnAdvisorDTO getAdvisorForStudent(Advisor advisor);
    OwnStudentDTO getStudentForAdvisor(Student student);


}
