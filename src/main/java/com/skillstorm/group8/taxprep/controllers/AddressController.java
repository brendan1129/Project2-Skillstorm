package com.skillstorm.group8.taxprep.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.group8.taxprep.models.Address;
import com.skillstorm.group8.taxprep.services.AddressService;

@RestController
@RequestMapping("/addresses")
@CrossOrigin("*")
public class AddressController {

    /* ATTRIBUTES */

    @Autowired
    AddressService addressService;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all addresses
    @GetMapping
    public ResponseEntity<List<Address>> findAllAddresses() {
        List<Address> addresses = addressService.findAllAddresses();
        return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);
    }

    // Creates a new address
    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@Valid @RequestBody Address address) {
        // Save the address
        Address newAddress = addressService.saveAddress(address);
        return new ResponseEntity<Address>(newAddress, HttpStatus.CREATED);
    }

    // Deletes an address
    @DeleteMapping("/address")
    public ResponseEntity<Address> deleteAddress(@RequestBody Address address) {
        // Deletes the address
        addressService.deleteAddress(address);
        return ResponseEntity.noContent().build();
    }

    // Update an address by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable int id, @Valid @RequestBody Address updatedAddress) {
        Address updatedAddressResult = addressService.updateAddress(id, updatedAddress);
        if (updatedAddressResult == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAddressResult);
    }

    /* METHODS */
    
}
