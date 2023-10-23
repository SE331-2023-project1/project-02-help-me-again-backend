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
    String name;
    String surname;
    @ElementCollection
    List<String> images;
    String department;
    String academic;
    @OneToMany(mappedBy = "advisor")
    @Builder.Default
    List<Student> ownStudent = new ArrayList<>();
    @OneToOne
    User user;
}


