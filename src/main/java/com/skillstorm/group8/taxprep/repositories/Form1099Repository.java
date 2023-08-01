package com.skillstorm.group8.taxprep.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillstorm.group8.taxprep.models.Form1099;

public interface Form1099Repository extends MongoRepository<Form1099, String>{

    Optional<Form1099> findForm1099sByPayerTIN(String ptin);

    Optional<List<Form1099>> findForm1099sByEmail(String email);
    
}
