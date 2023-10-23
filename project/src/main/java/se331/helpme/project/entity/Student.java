package se331.helpme.project.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.helpme.project.security.user.User;

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
    String name;
    String surname;
    @ElementCollection
    List<String> images;
    String department;
    @ManyToOne
    Advisor advisor;
    @OneToOne
    User user;
}