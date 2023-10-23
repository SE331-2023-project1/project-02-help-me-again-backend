package se331.helpme.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String firstName;
    String lastName;
    String student_ID;
    String registered;

    @ManyToOne
    Advisor advisor;

    @ElementCollection
    List<String> stu_pic;
}