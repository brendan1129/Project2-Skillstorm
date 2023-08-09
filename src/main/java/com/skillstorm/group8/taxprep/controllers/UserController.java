package com.skillstorm.group8.taxprep.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.group8.taxprep.models.User;
import com.skillstorm.group8.taxprep.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowCredentials = "true", originPatterns = "http://localhost:8080")
public class UserController {

    /* ATTRIBUTES */

    @Autowired
    UserService userService;

    @Autowired
    private OAuth2AuthorizedClientService clientService;

    /* CRUD FUNCTIONS */

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
        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    // Update a user by email
    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User updatedUser) {
        User updatedUserResult = userService.updateUser(updatedUser);
        if (updatedUserResult == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUserResult);
    }

     // Deletes a user
    @DeleteMapping("/user")
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        // Deletes the user
        userService.deleteUser(user);
        return ResponseEntity.noContent().build();
    }

    /* METHODS */

    // Finds a user by their email
    @GetMapping("/email")
    public ResponseEntity<User> findUserByEmail(@RequestParam String email) {
        User user = userService.findUserByEmail(email);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // Finds a user by their OAuth email and verifies they exist in the DB via a return
    @GetMapping("/authorized")
    public ResponseEntity<User> checkUserisAuthorized(@AuthenticationPrincipal OAuth2User principal) {
        String userEmail = principal.getAttribute("email");
        User user = userService.findUserByEmail(userEmail);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Creates a new user
    @PostMapping("/user/{maritalStatusString}")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user, @PathVariable String maritalStatusString) {
        User newUser = user;
        //newUser.setMaritalStatus(Enum.valueOf(MaritalStatus.class, maritalStatusString));
        // Save the user
        userService.saveUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    // Adds a user with a W2 and 1099
    @PostMapping("/user2")
    public ResponseEntity<User> createUser2(@Valid @RequestBody User user) {
        List<Integer> myList = new ArrayList<>();
        myList.add(123456789);
        User newUser = userService.saveUser(user, myList);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    // Updates a user with the provided response body and a path variable for the ENUM maritalStatus
    @PutMapping("/update-user/{maritalStatusString}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable String maritalStatusString) {
        User newUser = user;
       // newUser.setMaritalStatus(Enum.valueOf(MaritalStatus.class, maritalStatusString));
        // Save the user
        userService.saveUser(user);
        // List<Integer> myList = new ArrayList<>();
        // myList.add(123456789);
        // User newUser = userService.saveUser(user, myList);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    // Returns user's access token
    @GetMapping("/accessToken")
    public String accessToken(Authentication auth) {
        if(auth instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) auth;
            OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(authToken.getAuthorizedClientRegistrationId(), authToken.getName());
            return client.getAccessToken().getTokenValue();
        }
        return "";
    }
    // Returns all information relating to User's OAuth account
    @GetMapping("/principal")
    public OAuth2User getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        return principal;
    }
}
