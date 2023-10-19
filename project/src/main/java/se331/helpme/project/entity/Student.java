package se331.helpme.project.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    Long id;
    String FirstName;
    String LastName;
    String Student_ID;
    String registered;
    Number advisor;
    String stu_pic;
}