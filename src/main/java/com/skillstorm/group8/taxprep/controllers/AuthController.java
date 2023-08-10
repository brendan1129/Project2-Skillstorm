package com.skillstorm.group8.taxprep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.group8.taxprep.models.Auth;
import com.skillstorm.group8.taxprep.services.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/email")
    public String privateInfo(Principal principal, Authentication auth) {
        return principal.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody Auth auth) {
        authService.register(auth);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


}
