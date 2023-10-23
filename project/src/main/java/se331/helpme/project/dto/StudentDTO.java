package se331.helpme.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long id;
    String student_ID;
    String firstName;
    String lastName;
    String registered;
    OwnAdvisorDTO advisor;
    List<String> stu_pic;
}
