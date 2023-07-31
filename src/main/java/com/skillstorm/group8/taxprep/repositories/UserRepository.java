package com.skillstorm.group8.taxprep.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillstorm.group8.taxprep.models.User;

public interface UserRepository extends MongoRepository<User, Integer>{

    Optional<User> findUserByEmail(String email);
    
}
