package com.skillstorm.group8.taxprep.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillstorm.group8.taxprep.models.Address;

public interface AddressRepository extends MongoRepository<Address, Integer> {



}