package se331.helpme.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.helpme.project.security.user.Role;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long id;
    String username;
    String firstName;
    String lastName;
    List<String> images;
    String department;
    OwnStudentDTO advisor;
    List<Role> roles = new ArrayList<>();
}
