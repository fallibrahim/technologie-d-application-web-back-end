package sn.unchk.formateur_service.security;

import jakarta.ws.rs.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import java.util.List;

import static jakarta.ws.rs.HttpMethod.PUT;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> {})
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/formateurs/**").hasRole("ADMIN")

                        .requestMatchers(PUT, "/api/formateurs/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }


}
