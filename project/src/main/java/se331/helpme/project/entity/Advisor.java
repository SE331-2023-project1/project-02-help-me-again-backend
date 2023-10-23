package se331.helpme.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String advisor_ID;
    String firstName;
    String lastName;
    String email;
    String office;

    @ElementCollection
    List<String> advisor_pic;
    String department;

    @OneToMany
    @Builder.Default
    List<Student> studentList = new ArrayList<>();
}

