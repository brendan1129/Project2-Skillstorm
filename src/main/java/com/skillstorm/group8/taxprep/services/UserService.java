package com.skillstorm.group8.taxprep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.models.User;

import com.skillstorm.group8.taxprep.repositories.UserRepository;

@Service
public class UserService {

    /* ATTRIBUTES */

    @Autowired
    UserRepository userRepository;

    /* CRUD FUNCTIONS*/

    // Retrieves a list of all users
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Saves a user
    public User saveUser(User user) {
        /*
       Address updatedAddress = user.getAddress();
        if (updatedAddress != null) {
            // Check if the address has an ID (if it's persisted in the database)
            if (updatedAddress.getId() != 0) {
                // Update the existing address in the database
                addressService.updateAddress(updatedAddress.getId(), updatedAddress);
            } else {
                // Save the new address in the database and set it in the user
                Address newAddress = addressService.saveAddress(updatedAddress);
                user.setAddress(newAddress);
            }
        } */
        return userRepository.save(user);
    }

    // Deletes a user
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    // Update a user with the provided updatedUser object
    public User updateUser(String email, User updatedUser) {
        // Find the existing user by email
        Optional<User> optionalExistingUser = userRepository.findUserByEmail(email);
        if (!optionalExistingUser.isPresent()) {
            return null;
        }
        User existingUser = optionalExistingUser.get();
        // Manually update the user fields that are allowed to be updated
        if (updatedUser.getFirstName() != null) {
            existingUser.setFirstName(updatedUser.getFirstName());
        }
        if (updatedUser.getLastName() != null) {
            existingUser.setLastName(updatedUser.getLastName());
        }
        if(updatedUser.getPassword() != null) {
            existingUser.setPassword(updatedUser.getPassword());
        }
        if(updatedUser.getDateOfBirth() != null) {
            existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
        }
        if(updatedUser.getMaritalStatus() != null) {
            existingUser.setMaritalStatus(updatedUser.getMaritalStatus());
        }
        if(updatedUser.getAddress() != null) {
            existingUser.setAddress(updatedUser.getAddress());
        }
        return userRepository.save(existingUser);
    }

    /* METHODS */

    // Finds a user by their email
    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isPresent())
            return user.get();

        return null;
    }

    // Saves a user with some temporary logic for assigning Primary Key values if the user is created with a W2 and 1099
    public User saveUser(User user, List<Integer> list) {
        // if (user.getIncomeFrom1099().size() > 0) {
        // for (int i = 0; i < user.getIncomeFrom1099().size(); i++) {
        // user.getIncomeFromW2().get(i).setEmployerEIN("1234567890");
        // }
        // }

        // if (user.getIncomeFromW2().size() > 0) {
        // for (int j = 0; j < user.getIncomeFrom1099().size(); j++) {
        // user.getIncomeFrom1099().get(j).setPayerTIN("123456789");
        // }
        // }

        return userRepository.save(user);
    }
}
