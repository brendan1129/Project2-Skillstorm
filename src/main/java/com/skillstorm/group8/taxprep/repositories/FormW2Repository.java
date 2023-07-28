package com.skillstorm.group8.taxprep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.group8.taxprep.forms.FormW2;
import java.util.Optional;


@Repository
public interface FormW2Repository extends JpaRepository<FormW2, Integer> {
    
    Optional<FormW2> findByEmployerEIN(String employerEIN);
}
