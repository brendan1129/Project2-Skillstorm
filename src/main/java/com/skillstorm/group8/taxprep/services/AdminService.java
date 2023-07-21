package com.skillstorm.group8.taxprep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.models.Admin;
import com.skillstorm.group8.taxprep.repositories.AdminRepository;

@Service
public class AdminService {

    /* ATTRIBUTES */

    @Autowired
    AdminRepository adminRepository;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all admins
    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    // Saves an admin
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Deletes an admin
    public void deleteAdmin(Admin admin) {
        adminRepository.delete(admin);
    }

    // Update an admin with the provided updatedAdmin object
    public Admin updateAdmin(int id, Admin updatedAdmin) {
        // Find the existing admin by id
        Optional<Admin> optionalExistingAdmin = adminRepository.findById(id);
        if (!optionalExistingAdmin.isPresent()) {
            return null;
        }
        Admin existingAdmin = optionalExistingAdmin.get();
        // Manually update the admin fields that are allowed to be updated
        if (updatedAdmin.getFirstName() != null) {
            existingAdmin.setFirstName(updatedAdmin.getFirstName());
        }
        if (updatedAdmin.getLastName() != null) {
            existingAdmin.setLastName(updatedAdmin.getLastName());
        }
        // Update other fields as needed...
        return adminRepository.save(existingAdmin);
    }

    /* METHODS */
    
}
