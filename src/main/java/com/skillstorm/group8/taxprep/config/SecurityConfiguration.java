package com.skillstorm.group8.taxprep.config;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.skillstorm.group8.taxprep.filter.JwtFilter;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    JwtFilter jwtFilter;


/* 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        
        http
            .csrf().disable()
            .authorizeHttpRequests((authorizeHttpRequests) ->
                 authorizeHttpRequests
            .mvcMatchers(HttpMethod.POST, "/auth/register").permitAll()
            .mvcMatchers("/users/email").authenticated()
            .mvcMatchers("/auth/email").authenticated()
            

        )
        .httpBasic();
            
    return http.build();
        
    }
*/
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http = http.csrf().disable();

        http = http.cors().disable();

        http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

        http = http.exceptionHandling().authenticationEntryPoint((request, response, ex)-> {
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                    }).and();
        http.authorizeRequests()
            .mvcMatchers("/auth/login").permitAll()
            .mvcMatchers("/auth/register").permitAll()
                    .anyRequest().authenticated();
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
    
}
