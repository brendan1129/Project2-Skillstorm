package com.skillstorm.group8.taxprep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.models.Form1099;
import com.skillstorm.group8.taxprep.models.FormW2;
import com.skillstorm.group8.taxprep.models.TaxForms;
import com.skillstorm.group8.taxprep.models.User;
import com.skillstorm.group8.taxprep.repositories.Form1099Repository;
import com.skillstorm.group8.taxprep.repositories.FormW2Repository;
import com.skillstorm.group8.taxprep.repositories.TaxFormsRepository;
import com.skillstorm.group8.taxprep.repositories.UserRepository;

@Service
public class UserService {

    /* ATTRIBUTES */

    @Autowired
    UserRepository userRepository;

    @Autowired
    Form1099Repository form1099Repository;

    @Autowired
    FormW2Repository formW2Repository;

    @Autowired
    TaxFormsRepository taxFormsRepository;

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

    // Update a user with the provided updatedUser object
    public User updateUser(User updatedUser) {
        Optional<User> optionalExistingUser = userRepository.findByEmail(updatedUser.getEmail());
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
        Optional<User> user = userRepository.findByEmail(email);
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

    // Deletes a user
    public void deleteUser(User user) {
        userRepository.delete(user);

        // deletes the user's saved W2 forms
        Optional<List<FormW2>> allW2Forms = formW2Repository.findFormW2sByEmail(user.getEmail());
        if (allW2Forms.isPresent()) {
            for (FormW2 w : allW2Forms.get()) {
                formW2Repository.delete(w);
            }
        }

        // deletes the user's saved 1099 forms
        Optional<List<Form1099>> all1099Forms = form1099Repository.findForm1099sByEmail(user.getEmail());
        if (all1099Forms.isPresent()) {
            for (Form1099 x : all1099Forms.get()) {
                form1099Repository.delete(x);
            }
        }

        // deletes the user's tax information
        Optional<TaxForms> taxForms = taxFormsRepository.findTaxFormsByEmail(user.getEmail());
        if (taxForms.isPresent()) {
            taxFormsRepository.delete(taxForms.get());
        }
    }

}
