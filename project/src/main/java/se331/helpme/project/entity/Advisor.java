package se331.helpme.project.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Advisor {
    Long id;
    String firstName;
    String lastName;
    String department;
    String email;
    String office;
    String advisor_pic;
}

