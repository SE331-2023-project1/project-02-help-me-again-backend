package se331.helpme.project.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}