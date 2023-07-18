package com.skillstorm.group8.taxprep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.group8.taxprep.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    
}
