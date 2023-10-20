package se331.helpme.project.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    Long id;
    String firstName;
    String lastName;
    String student_ID;
    String registered;
    Number advisor;
    String stu_pic;
}