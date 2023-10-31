package se331.helpme.project.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.helpme.project.security.user.User;

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
    String firstName;
    String lastName;
    @ElementCollection
    List<String> images;
    String department;
    String academic;
    String office;
    String advisor_pic;
    @OneToMany(mappedBy = "advisor")
    @Builder.Default
    List<Student> studentList = new ArrayList<>();
    @OneToOne
    User user;
}


