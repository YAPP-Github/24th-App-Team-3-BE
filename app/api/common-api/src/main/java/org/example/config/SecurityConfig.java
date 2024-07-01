package org.example.config;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.example.filter.ExceptionHandlerFilter;
import org.example.filter.JWTFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JWTFilter jwtFilter;
    private final ExceptionHandlerFilter exceptionHandlerFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .cors(corsConfigurer -> corsConfigurer.configurationSource(
                corsConfigurationSource()))
            .formLogin(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .sessionManagement(
                configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(registry ->
                registry
                    .requestMatchers(
                        "/swagger-ui/**", "/v3/api-docs/**",
                        "/api/v1/users/login", "/api/v1/admin/**",
                        "/css/**", "/js/**"
                    ).permitAll()
                    .requestMatchers(
                        HttpMethod.GET,
                        "/api/v1/artists",
                        "/api/v1/genres",
                        "/api/v1/shows"
                    ).permitAll()
                    .requestMatchers(
                        HttpMethod.GET,
                        "/api/v1/shows/interests"
                    ).hasAnyRole("USER", "ADMIN")
                    .requestMatchers(
                        HttpMethod.POST,
                        "/api/v1/users/logout",
                        "/api/v1/shows/**/interest",
                        "/api/v1/shows/**/alert"
                    ).hasAnyRole("USER", "ADMIN")
                    .requestMatchers(
                        HttpMethod.POST,
                        "/api/v1/artists",
                        "/api/v1/genres",
                        "/api/v1/shows"
                    ).hasRole("ADMIN")
                    .requestMatchers(
                        HttpMethod.DELETE,
                        "/api/v1/admin/genres/**"
                    ).hasRole("ADMIN")
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(exceptionHandlerFilter, JWTFilter.class)
            .build();
    }

    private CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.setAllowedOriginPatterns(Collections.singletonList("*"));
            return config;
        };
    }
}
