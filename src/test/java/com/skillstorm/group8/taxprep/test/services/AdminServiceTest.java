package com.skillstorm.group8.taxprep.test.services;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;



import com.skillstorm.group8.taxprep.models.Admin;
import com.skillstorm.group8.taxprep.repositories.AdminRepository;
import com.skillstorm.group8.taxprep.services.AdminService;

@SpringBootTest
@Transactional // Add this annotation to enable transaction management for test methods
public class AdminServiceTest {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminService adminService;

    @Test
    public void testFindAllAdmins() {
        // Create some sample admins and persist them in the database
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        admin1.setFirstName("John");
        admin1.setLastName("Doe");
        admin2.setFirstName("Jane");
        admin2.setLastName("Doe");
        adminRepository.save(admin1);
        adminRepository.save(admin2);

        // Call the service method
        List<Admin> result = adminService.findAllAdmins();

        // Assert the result
        assertEquals(2, result.size());
        System.out.println("testFindAllAdmins Passed!");
    }

    @Test
    public void testSaveAdmin() {
        // Create a sample admin to save
        Admin adminToSave = new Admin();
        adminToSave.setFirstName("Allison");
        adminToSave.setLastName("Wonderland");

        // Call the service method
        Admin savedAdmin = adminService.saveAdmin(adminToSave);

        // Assert the result
        assertEquals(adminToSave.getFirstName(), savedAdmin.getFirstName());
        assertEquals(adminToSave.getLastName(), savedAdmin.getLastName());

        // Verify that the admin is persisted in the database
        Optional<Admin> retrievedAdmin = adminRepository.findById(savedAdmin.getId());
        assertEquals(adminToSave.getFirstName(), retrievedAdmin.get().getFirstName());
        assertEquals(adminToSave.getLastName(), retrievedAdmin.get().getLastName());

        System.out.println("testSaveAdmin Passed!");
    }

    @Test
    public void testUpdateAdmin() {
        // Create a sample admin and persist it in the database
        Admin existingAdmin = new Admin();
        existingAdmin.setFirstName("Mike");
        existingAdmin.setLastName("Lient");
        adminRepository.save(existingAdmin);

        // Create a sample updated admin
        Admin updatedAdmin = new Admin();
        updatedAdmin.setId(existingAdmin.getId());
        updatedAdmin.setFirstName(existingAdmin.getFirstName());
        updatedAdmin.setLastName(existingAdmin.getLastName());
        // Call the service method
        Admin result = adminService.updateAdmin(existingAdmin.getId(), updatedAdmin);

        // Assert the result
        assertEquals(updatedAdmin.getFirstName(), result.getFirstName());
        assertEquals(updatedAdmin.getLastName(), result.getLastName());

        // Verify that the admin is updated in the database
        Optional<Admin> retrievedAdmin = adminRepository.findById(existingAdmin.getId());
        assertEquals(updatedAdmin.getFirstName(), retrievedAdmin.get().getFirstName());
        assertEquals(updatedAdmin.getLastName(), retrievedAdmin.get().getLastName());

        System.out.println("testUpdateAdmin Passed!");
    }

    @Test
    public void testUpdateAdmin_NonExistentId() {
        // Call the service method with a non-existent ID
        Admin updatedAdmin = new Admin();
        updatedAdmin.setId(1234);
        updatedAdmin.setFirstName("John");
        updatedAdmin.setLastName("Doe");
        Admin result = adminService.updateAdmin(1234, updatedAdmin);

        // Assert the result should be null for a non-existent ID
        assertNull(result);

        System.out.println("testUpdateAdmin_NonExistentId Passed!");
    }
}