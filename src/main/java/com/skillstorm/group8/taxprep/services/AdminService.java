package com.skillstorm.group8.taxprep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.models.Admin;
import com.skillstorm.group8.taxprep.repositories.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    AdminRepository adminRepository;

    public List<Admin> findAllUsers() {
        return adminRepository.findAll();
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

}
