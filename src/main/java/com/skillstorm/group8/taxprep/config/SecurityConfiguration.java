package com.skillstorm.group8.taxprep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        
        http
            .csrf().disable()
            .authorizeHttpRequests((authorizeHttpRequests) ->
                 authorizeHttpRequests
            .mvcMatchers(HttpMethod.POST, "/auth/register").permitAll()
            .mvcMatchers("/users").authenticated()
            

        )
        .httpBasic();
            
    return http.build();
        
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
    
}
