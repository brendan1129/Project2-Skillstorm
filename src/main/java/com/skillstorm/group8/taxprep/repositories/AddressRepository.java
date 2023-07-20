package com.skillstorm.group8.taxprep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.group8.taxprep.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {



}