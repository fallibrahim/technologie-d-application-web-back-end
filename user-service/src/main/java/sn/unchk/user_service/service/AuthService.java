package sn.unchk.user_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.unchk.user_service.Repository.UserRepository;
import sn.unchk.user_service.dtos.AuthRequest;
import sn.unchk.user_service.dtos.AuthResponse;
import sn.unchk.user_service.dtos.RegisterRequest;
import sn.unchk.user_service.enums.Role;
import sn.unchk.user_service.model.User;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .nom(request.getNom())
                .email(request.getEmail())
                .motDePasse(passwordEncoder.encode(request.getMotDePasse()))
                .role(request.getRole())
                .build();

        userRepository.save(user);

        var token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getMotDePasse()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        var token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
