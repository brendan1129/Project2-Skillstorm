package com.skillstorm.group8.taxprep.test.models;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.skillstorm.group8.taxprep.models.MaritalStatus;
import com.skillstorm.group8.taxprep.models.User;

public class UserTest {

    // Test getters and setters of basic fields
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("john.doe@gmail.com");
        user.setSsn("123-45-6789");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPassword("password");

        assertNotNull(user);
        assertEquals("john.doe@gmail.com", user.getEmail());
        assertEquals("123-45-6789", user.getSsn());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("password", user.getPassword());
        System.out.println("Create User Test Passed!");
    }
    // Test getters and setters of MaritalStatus enum
    @Test
    public void testSetMaritalStatus() {
        User user = new User();
        user.setMaritalStatus(MaritalStatus.SINGLE);

        assertEquals(MaritalStatus.SINGLE, user.getMaritalStatus());
        System.out.println("User MaritalStatus Test Passed!");
    }

    // Test getters and setters of DOB
    @Test
    public void testSetDateOfBirth() {
        User user = new User();
        user.setDateOfBirth(new Date());

        assertNotNull(user.getDateOfBirth());
        System.out.println("User DOB Test Passed!");
    }
}