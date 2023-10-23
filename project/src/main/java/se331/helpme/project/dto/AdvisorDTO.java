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
public class TeacherDTO {

    Long id;
    String username;
    String name;
    String surname;
    List<String> images;
    String department;
    String academic;
    List<OwnStudentDTO> ownStudent = new ArrayList<>();
    List<Role> roles = new ArrayList<>();
}

