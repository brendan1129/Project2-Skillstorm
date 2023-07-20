package com.skillstorm.group8.taxprep.test.services;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skillstorm.group8.taxprep.services.UserService;
import com.skillstorm.group8.taxprep.models.User;
import com.skillstorm.group8.taxprep.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveUser() {
        User user = new User();
        user.setEmail("test@example.com");

        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertEquals(user.getEmail(), savedUser.getEmail());
        System.out.println("shouldSaveUser Passed!");
    }

    @Test
    void shouldFindUserByEmail() {
        User user = new User();
        user.setEmail("test@example.com");
        userService.saveUser(user);

        User foundUser = userService.findUserByEmail("test@example.com");

        assertNotNull(foundUser);
        assertEquals(user.getEmail(), foundUser.getEmail());

        System.out.println("shouldFindUserByEmail Passed!");
    }

    @Test
    void shouldUpdateUser() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setFirstName("Jane");
        user.setLastName("Doe");

        User foundUser = userService.updateUser(user.getEmail(), user);

        assertNotNull(foundUser);
        assertEquals(foundUser.getEmail(), "test@example.com");
        assertEquals(foundUser.getFirstName(), "Jane");
        assertEquals(foundUser.getLastName(), "Doe");

        System.out.println("shouldUpdateUser Passed!");
    }
    @Test
    void shouldDeleteUser() {
        User user = new User();
        user.setEmail("test@example.com");

        userService.deleteUser(user);

        System.out.println("shouldDeleteUser Passed!");
    }
    @Test
    void shouldReturnNullWhenUserNotFound() {
        User foundUser = userService.findUserByEmail("notFound@example.com");

        assertNull(foundUser);

        System.out.println("shouldReturnNullWhenUserNotFound Passed!");
    }
}