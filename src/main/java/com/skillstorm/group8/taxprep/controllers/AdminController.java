package com.skillstorm.group8.taxprep.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public ResponseEntity<List<Admin>> findAllAdmins() {
        List<Admin> admins = adminService.findAllUsers();
        return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
    }
    
}
