package se331.helpme.project.security.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import se331.helpme.project.entity.Advisor;
import se331.helpme.project.entity.Student;
import se331.helpme.project.repository.AdvisorRepository;
import se331.helpme.project.repository.StudentRepository;
import se331.helpme.project.security.token.Token;
import se331.helpme.project.security.token.TokenRepository;
import se331.helpme.project.security.token.TokenType;
import se331.helpme.project.security.user.Role;
import se331.helpme.project.security.user.User;
import se331.helpme.project.security.user.UserRepository;
import se331.helpme.project.util.LabMapper;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final StudentRepository studentRepository;
    private final AdvisorRepository advisorRepository;

    public AuthenticationResponse registerStudent(RegisterRequest request) {

        User userStudent = User.builder()
                .username(request.getUsername())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(Role.ROLE_STUDENT))
                .images(request.getImages())
                .build();
        var savedUser = repository.save(userStudent);
        Advisor advisor = new Advisor();
        advisor = advisorRepository.getById(1L).getUser().getAdvisor();
        Student student = new Student();
        student.setUser(savedUser);
        student.setAdvisor(advisor);
        studentRepository.save(student);
        var jwtToken = jwtService.generateToken(userStudent);
        var refreshToken = jwtService.generateRefreshToken(userStudent);
        saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse registerAdvisor(RegisterRequest request) {

        User userAdvisor = User.builder()
                .username(request.getUsername())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(Role.ROLE_ADVISOR))
                .images(request.getImages())
                .build();
        var savedUser = repository.save(userAdvisor);
        Advisor advisor = new Advisor();
        advisor.setUser(savedUser);
        advisorRepository.save(advisor);
        var jwtToken = jwtService.generateToken(userAdvisor);
        var refreshToken = jwtService.generateRefreshToken(userAdvisor);
        saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = repository.findByUsername(request.getUsername())
                .orElseThrow();

        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        List<Role> userRoles = user.getRoles();
        Integer id = user.getId();
        if (user.getAdvisor() != null) {
            Long advisorId = user.getAdvisor().getId();
            id = Math.toIntExact(advisorId);
        } else if (user.getStudent() != null){
            Long studentId = user.getStudent().getId();
            id = Math.toIntExact(studentId);
        }

//    revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
//    System.out.println(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .userRole(userRoles)
                .id(id)
//            .user(LabMapper.INSTANCE.getOrganizerAuthDTO(user.getOrganizer()))
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            User user = this.repository.findByUsername(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                String accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                AuthenticationResponse authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}

