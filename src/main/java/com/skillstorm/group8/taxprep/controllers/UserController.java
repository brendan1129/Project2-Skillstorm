package com.skillstorm.group8.taxprep.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
        User user = userService.findUserByEmail(email);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        List<Integer> myList = new ArrayList<>();
        myList.add(123456789);
        User newUser = userService.saveUser(user, myList);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/user/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        List<Integer> myList = new ArrayList<>();
        myList.add(123456789);
        User newUser = userService.saveUser(user, myList);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/user")
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        return ResponseEntity.noContent().build();
    }

}
