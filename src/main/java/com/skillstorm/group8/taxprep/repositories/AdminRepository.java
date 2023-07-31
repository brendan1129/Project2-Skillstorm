package com.skillstorm.group8.taxprep.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.skillstorm.group8.taxprep.models.Admin;

public interface AdminRepository extends MongoRepository<Admin, Integer>{
    
}
