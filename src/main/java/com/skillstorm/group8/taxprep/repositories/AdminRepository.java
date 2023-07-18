package com.skillstorm.group8.taxprep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.group8.taxprep.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
    
}
