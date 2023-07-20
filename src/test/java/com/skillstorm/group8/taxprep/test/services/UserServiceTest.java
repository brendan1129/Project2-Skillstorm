package com.skillstorm.group8.taxprep.test.services;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skillstorm.group8.taxprep.services.UserService;
import com.skillstorm.group8.taxprep.models.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void shouldSaveUser() {
        User user = new User();
        user.setEmail("test@example.com");

        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertEquals(user.getEmail(), savedUser.getEmail());
        System.out.println("UserService Save Test Passed!");
    }

    @Test
    void shouldFindUserByEmail() {
        User user = new User();
        user.setEmail("test@example.com");
        userService.saveUser(user);

        User foundUser = userService.findUserByEmail("test@example.com");

        assertNotNull(foundUser);
        assertEquals(user.getEmail(), foundUser.getEmail());

        System.out.println("UserService findbyEmail Test Passed!");
    }

    @Test
    void shouldReturnNullWhenUserNotFound() {
        User foundUser = userService.findUserByEmail("notFound@example.com");

        assertNull(foundUser);

        System.out.println("UserService userNotFound Test Passed!");
    }
}