package test.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import com.skillstorm.group8.taxprep.models.Address;
import com.skillstorm.group8.taxprep.models.User;

public class UserTest {

    // The model unit tests essentially test creation of an instance and setting attributes of the model

    @Test
    public void testCreateUser() {
        // Create a new user
        Calendar c = Calendar.getInstance();
        User user = new User("john.doe@gmail.com", "123-45-6789", "John", "Doe",
                new Address(12345, "123 Main Street", "Apartment #3", "Anytown", "CA", 12345),
                c.getTime(), "Single");

        // Assert that the user was created successfully
        assertEquals("john.doe@gmail.com", user.getEmail());
        assertEquals("123-45-6789", user.getSsn());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(c.getTime(), user.getDateOfBirth());
        assertEquals("Single", user.getMaritalStatus());
    }
    @Test
    public void testSetEmail() {
        // Create a new user
        User user = new User();

        // Set the user's email
        user.setEmail("john.doe@gmail.com");

        // Assert that the email was set correctly
        assertEquals("john.doe@gmail.com", user.getEmail());
    }

    @Test
    public void testSetSsn() {
        // Create a new user
        User user = new User();

        // Set the user's SSN
        user.setSsn("123-45-6789");

        // Assert that the SSN was set correctly
        assertEquals("123-45-6789", user.getSsn());
    }

    @Test
    public void testSetFirstName() {
        // Create a new user
        User user = new User();

        // Set the user's first name
        user.setFirstName("John");

        // Assert that the first name was set correctly
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void testSetLastName() {
        // Create a new user
        User user = new User();

        // Set the user's last name
        user.setLastName("Doe");

        // Assert that the last name was set correctly
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void testSetMaritalStatus() {
        // Create a new user
        User user = new User();

        // Set the user's marital status
        user.setMaritalStatus("Single");

        // Assert that the marital status was set correctly
        assertEquals("Single", user.getMaritalStatus());
    }
}