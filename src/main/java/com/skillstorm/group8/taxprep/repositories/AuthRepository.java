package com.skillstorm.group8.taxprep.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillstorm.group8.taxprep.models.Auth;

public interface AuthRepository extends MongoRepository<Auth, String>{

    public Optional<Auth> findByEmail(String email);
    
}
