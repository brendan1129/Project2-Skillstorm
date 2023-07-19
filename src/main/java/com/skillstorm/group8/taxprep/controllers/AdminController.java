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

import com.skillstorm.group8.taxprep.models.Admin;
import com.skillstorm.group8.taxprep.services.AdminService;

@RestController
@RequestMapping("/admins")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    AdminService adminService;

    // Retrieves a list of all admins
    @GetMapping
    public ResponseEntity<List<Admin>> findAllAdmins() {
        List<Admin> admins = adminService.findAllAdmins();
        return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
    }

    // Creates a new admin
    @PostMapping("/admin")
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) {
        // Save the admin
        Admin newAdmin = adminService.saveAdmin(admin);
        return new ResponseEntity<Admin>(newAdmin, HttpStatus.CREATED);
    }

    // Deletes an admin
    @DeleteMapping("/admin")
    public ResponseEntity<Admin> deleteAdmin(@RequestBody Admin admin) {
        // Deletes the admin
        adminService.deleteAdmin(admin);
        return ResponseEntity.noContent().build();
    }
}
