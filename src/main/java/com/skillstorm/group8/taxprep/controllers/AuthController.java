package com.skillstorm.group8.taxprep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.group8.taxprep.dto.AuthCredentialsRequest;
import com.skillstorm.group8.taxprep.models.Auth;
import com.skillstorm.group8.taxprep.services.AuthService;
import com.skillstorm.group8.taxprep.util.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin(exposedHeaders = "Authorization", origins = "*")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody AuthCredentialsRequest request) {
        try {
            Authentication authenticate = authenticationManager
            .authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(), request.getPassword()
                )
            );

            Auth auth = (Auth) authenticate.getPrincipal();
            auth.setPassword(null);
            return ResponseEntity.ok()
                .header(
                    HttpHeaders.AUTHORIZATION,
                    jwtUtil.generateToken(auth)
                )
                .body(auth);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }



    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody Auth auth) {
        authService.register(auth);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


}
