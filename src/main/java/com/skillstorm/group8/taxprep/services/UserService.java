package com.skillstorm.group8.taxprep.services;

import java.util.List;
import java.util.Optional;

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
  
    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent())
            return user.get();

        return null;
    }
  
    public User saveUser(User user, List<Integer> list) {
        // if (user.getIncomeFrom1099().size() > 0) {
        //     for (int i = 0; i < user.getIncomeFrom1099().size(); i++) {
        //         user.getIncomeFromW2().get(i).setEmployerEIN("1234567890");
        //     }
        // }

        // if (user.getIncomeFromW2().size() > 0) {
        //     for (int j = 0; j < user.getIncomeFrom1099().size(); j++) {
        //         user.getIncomeFrom1099().get(j).setPayerTIN("123456789");
        //     }
        // }

        return userRepository.save(user);
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
