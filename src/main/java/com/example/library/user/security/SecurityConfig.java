package com.example.library.user.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/login", "/register", "/css/**", "/js/**", "/images/**").permitAll() // ← публичные страницы
                        .requestMatchers("/", "/home").permitAll() // ← главная страница публичная
                        .anyRequest().authenticated() // ← всё остальное требует входа
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login") // ← важно для обработки формы
                        .defaultSuccessUrl("/library", true) // ← force redirect
                        .failureUrl("/login?error=true") // ← при ошибке
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // ← URL для выхода
                        .logoutSuccessUrl("/?logout") // ← после выхода
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )
                .csrf(withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
