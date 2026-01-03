package com.example.library.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Для REST API отключаем CSRF
                .authorizeHttpRequests(authz -> authz
                        // Разрешаем все публичные эндпоинты
                        .requestMatchers(
                                "/registration",
                                "/user/getAllUsers",  // Уберите если не хотите публичный доступ
                                "/swagger-ui/**",     // Если используете Swagger
                                "/v3/api-docs/**"     // Документация API
                        ).permitAll()

                        .anyRequest().authenticated()
                )
                // Отключаем форму логина для REST API
                .formLogin(form -> form.disable())
                // Отключаем Basic Auth
                .httpBasic(basic -> basic.disable())
                // Делаем STATELESS (без сессий)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}