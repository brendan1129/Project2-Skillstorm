package com.skillstorm.group8.taxprep.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.group8.taxprep.models.User;
import com.skillstorm.group8.taxprep.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    // Retrieves a list of all users
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    // Creates a new user
    @PostMapping("/user") 
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {         
        // Save the user
        User newUser = userService.saveUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    // Deletes a user
    @DeleteMapping("/user") 
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        // Deletes the user  
        userService.deleteUser(user);
        return ResponseEntity.noContent().build();
    }
}
