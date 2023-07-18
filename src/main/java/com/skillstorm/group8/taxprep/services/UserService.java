package com.skillstorm.group8.taxprep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.group8.taxprep.models.User;
import com.skillstorm.group8.taxprep.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // Retrieves a list of all users
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Saves a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Deletes a user
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
