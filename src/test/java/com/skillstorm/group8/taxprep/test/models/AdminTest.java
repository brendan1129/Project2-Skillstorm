package com.skillstorm.group8.taxprep.test.models;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.skillstorm.group8.taxprep.models.Admin;

public class AdminTest {

    // Test constructor, getter and setter of Admin class
    @Test
    public void testCreateAdmin() {
        Admin admin = new Admin();
        admin.setFirstName("John");
        admin.setLastName("Doe");
        
        assertNotNull(admin);
        assertEquals("John", admin.getFirstName());
        assertEquals("Doe", admin.getLastName());
        System.out.println("testCreateAdmin Passed!");
    }
}
