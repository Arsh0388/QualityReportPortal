package com.example.QualityReportportal.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // security configuration - cors policy impementation handling 
    @Bean
    public CorsConfigurationSource CorsConfigurationSource() { 
        CorsConfiguration configuration = new CorsConfiguration();

        // set allowed origin 
        configuration.setAllowedOrigins(List.of(
            "http://localhost:5173"
        )); 
        // set allowed methods 
        configuration.setAllowedMethods(List.of(
            "GET",
            "POST",
            "PUT",
            "DELETE", 
            "OPTIONS"
        ));

        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); 
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    /**
     * Spring Security Configuration
     * every incoming requests goes through this 
     * Request → SecurityFilterChain → Controller
     */
    /*
    Request →
    CORS Filter
    CSRF Filter
    Authentication Filter
    Authorization Filter
    // the role based access control will take place here I guess , 
    → Controller
    */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .cors(Customizer.withDefaults()) // this tells spring spring to use my corsConfigurationSource Bean 
            .csrf(csrf -> csrf.disable()) // csrf is disabled cause we are implementing jwt token
            .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // only auth points are open public one 
                        // rest are protected endpoints 
                        .anyRequest().authenticated() // is it authenticated 
                );

        return http.build();
    }

}