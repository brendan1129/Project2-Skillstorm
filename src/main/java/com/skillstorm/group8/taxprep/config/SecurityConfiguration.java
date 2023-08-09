package com.skillstorm.group8.taxprep.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
                .authorizeHttpRequests(authorizeHttpRequests -> {
                    authorizeHttpRequests.anyRequest().authenticated();
                })
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {
                    cors.configurationSource(request -> {
                        CorsConfiguration corsConfig = new CorsConfiguration();
                        corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
                        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                        corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
                        corsConfig.setAllowCredentials(true);
                        corsConfig.setMaxAge(3600L); 
                        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                        source.registerCorsConfiguration("/**", corsConfig);

                        return corsConfig;
                    });
                });
        http.oauth2Login();
        return http.build();
    }
}
