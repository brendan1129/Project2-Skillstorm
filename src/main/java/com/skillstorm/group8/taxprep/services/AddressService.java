package com.skillstorm.group8.taxprep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.models.Address;
import com.skillstorm.group8.taxprep.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    /* ATTRIBUTES */

    @Autowired
    AddressRepository addressRepository;

    /* CRUD FUNCTIONS */

    // Retrieves a list of all addresses
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    // Saves an address
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    // Deletes an address
    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }

    // Update an address with the provided updatedAddress object
    public Address updateAddress(int id, Address updatedAddress) {
        // Find the existing address by id
        Optional<Address> optionalExistingAddress = addressRepository.findById(id);
        if (!optionalExistingAddress.isPresent()) {
            return null;
        }
        Address existingAddress = optionalExistingAddress.get();
        // Manually update the address fields that are allowed to be updated
        if (updatedAddress.getCity() != null) {
            existingAddress.setCity(updatedAddress.getCity());
        }
        if (updatedAddress.getState() != null) {
            existingAddress.setState(updatedAddress.getState());
        }
        if (updatedAddress.getStreetPrimary() != null) {
            existingAddress.setStreetPrimary(updatedAddress.getStreetPrimary());
        }
        if (updatedAddress.getStreetSecondary() != null) {
            existingAddress.setStreetSecondary(updatedAddress.getStreetSecondary());
        }
        if (updatedAddress.getZipCode() != null) {
            existingAddress.setZipCode(updatedAddress.getZipCode());
        }
        // Update other fields as needed...

        // Save the updated address
        return addressRepository.save(existingAddress);
    }

    /* METHODS */
    
}
