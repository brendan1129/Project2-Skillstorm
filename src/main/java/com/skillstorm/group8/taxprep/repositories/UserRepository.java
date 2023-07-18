package com.skillstorm.group8.taxprep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.group8.taxprep.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
