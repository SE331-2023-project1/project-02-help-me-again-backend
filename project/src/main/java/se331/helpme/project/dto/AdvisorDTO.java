package se331.helpme.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorDTO {
    Long id;
    String firstName;
    String lastName;
    String department;
    String email;
    String office;
    List<String> advisor_pic;
    List<OwnStudentDTO> studentList = new ArrayList<>();
}
