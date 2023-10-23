package se331.helpme.project.security.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.entity.Announcement;
import se331.helpme.project.entity.Student;
import se331.helpme.project.security.token.Token;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String parentId;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;
    @ElementCollection
    private List<String> images;
    private String department;
    private String academic;
    private String title;
    private String description;
    @ElementCollection
    private List<String> files;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
    @OneToOne(mappedBy = "user")
    Advisor advisor;
    @OneToOne(mappedBy = "user")
    Student student;
    @OneToMany(mappedBy = "user")
    private List<Announcement> announcements;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}