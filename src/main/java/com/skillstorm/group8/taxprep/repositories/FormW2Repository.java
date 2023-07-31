package com.skillstorm.group8.taxprep.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillstorm.group8.taxprep.forms.FormW2;
import java.util.Optional;


public interface FormW2Repository extends MongoRepository<FormW2, Integer> {
    
    Optional<FormW2> findByEmployerEIN(String employerEIN);
}
