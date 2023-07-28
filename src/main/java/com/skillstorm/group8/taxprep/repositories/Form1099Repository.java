package com.skillstorm.group8.taxprep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.group8.taxprep.forms.Form1099;
import java.util.Optional;


@Repository
public interface Form1099Repository extends JpaRepository<Form1099, Integer> {

    Optional<Form1099> findByPayerTIN(String payerTIN);
    
}
