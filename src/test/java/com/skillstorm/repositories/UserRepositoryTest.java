package com.skillstorm.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.skillstorm.group8.taxprep.models.Address;
import com.skillstorm.group8.taxprep.models.User;
import com.skillstorm.group8.taxprep.repositories.UserRepository;

@SpringBootTest(classes=UserRepository.class)
@SpringJUnitConfig
public class UserRepositoryTest {
    
    @Mock
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() throws Exception {
        // Arrange
        Calendar c = Calendar.getInstance();
        User user = new User("john.doe@gmail.com", "123-45-6789", "John", "Doe",
                    new Address(12345, "123 Main Street", "Apartment #3", "Anytown", "CA", 12345),
                    c.getTime(), "Single");
        userRepository.insert(user);
        Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        // Act
        Optional<User> actualUser = userRepository.findByEmail(user.getEmail());

        // Assert
        assertTrue(actualUser.isPresent());
        assertEquals(user, actualUser.get());
        // Clean up
        userRepository.delete(user);
    }
}
