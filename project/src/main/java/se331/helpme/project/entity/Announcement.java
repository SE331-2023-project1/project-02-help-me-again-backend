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
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String title;
    String description;
    @ElementCollection
    List<String> files;
    @ManyToOne
    User user;
}

