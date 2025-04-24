package sn.unchk.formation_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/formations/**").hasAnyRole("ETUDIANT", "ADMIN")

                        .requestMatchers("/api/formations/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
