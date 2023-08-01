package com.skillstorm.group8.taxprep.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillstorm.group8.taxprep.models.FormW2;

public interface FormW2Repository extends MongoRepository<FormW2, String>{

    Optional<FormW2> findFormW2sByEmployerEIN(String ein);

    Optional<List<FormW2>> findFormW2sByEmail(String email);
    
}
