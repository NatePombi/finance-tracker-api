package org.example.financetrackerapi.auth;

import lombok.AllArgsConstructor;
import org.example.financetrackerapi.user.User;
import org.example.financetrackerapi.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {

        if(repo.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }

        User user = User.create(request.getEmail(), passwordEncoder.encode(request.getPassword()));

        repo.save(user);

        return new AuthResponse(request.getEmail(), "Successfully registered");
    }
}
