package com.skillstorm.group8.taxprep.test.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.skillstorm.group8.taxprep.models.User;
import com.skillstorm.group8.taxprep.repositories.UserRepository;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        User user = new User();
        user.setEmail("john.doe@gmail.com");
        userRepository.save(user);

        Optional<User> foundUser = userRepository.findByEmail("john.doe@gmail.com");
        assertTrue(foundUser.isPresent());
        assertEquals("john.doe@gmail.com", foundUser.get().getEmail());
        System.out.println("User Repository findByEmail Test Passed!");
    }
}