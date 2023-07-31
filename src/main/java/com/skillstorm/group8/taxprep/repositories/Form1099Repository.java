package com.skillstorm.group8.taxprep.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillstorm.group8.taxprep.forms.Form1099;
import java.util.Optional;


public interface Form1099Repository extends MongoRepository<Form1099, Integer> {

    Optional<Form1099> findByPayerTIN(String payerTIN);
    
}
