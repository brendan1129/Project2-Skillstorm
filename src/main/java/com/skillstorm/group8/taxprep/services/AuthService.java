package com.skillstorm.group8.taxprep.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.models.Auth;
import com.skillstorm.group8.taxprep.repositories.AuthRepository;

@Service
public class AuthService implements UserDetailsService{

    @Autowired
    AuthRepository authRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Auth auth = authRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + "not found."));
        return auth;
    }

    public void register(Auth auth) {
        Optional<Auth> foundAuth = authRepository.findByEmail((auth.getEmail()));
        if(foundAuth.isPresent()) {
            throw new RuntimeException("User with that username already exists.");
        }

        auth.setPassword(passwordEncoder.encode(auth.getPassword()));

        auth.setRole("ROLE_USER");

        authRepository.save(auth);

    }

    
}
