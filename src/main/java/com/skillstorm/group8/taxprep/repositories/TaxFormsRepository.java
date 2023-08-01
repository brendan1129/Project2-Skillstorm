package com.skillstorm.group8.taxprep.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillstorm.group8.taxprep.models.TaxForms;

public interface TaxFormsRepository extends MongoRepository<TaxForms, String>{

    Optional<TaxForms> findTaxFormsByEmail(String email);
    
}
