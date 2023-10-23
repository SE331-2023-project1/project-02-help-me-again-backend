package se331.helpme.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnAdvisorDTO {
    Long id;
    String firstName;
    String lastName;
    String department;
    String email;
    String office;
    String advisor_ID;
}
