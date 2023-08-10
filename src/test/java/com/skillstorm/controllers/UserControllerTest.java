package com.skillstorm.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.skillstorm.group8.taxprep.controllers.UserController;
import com.skillstorm.group8.taxprep.models.Address;
import com.skillstorm.group8.taxprep.models.User;
import com.skillstorm.group8.taxprep.services.UserService;

@SpringBootTest(classes=UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testFindAllUsers() throws Exception {
        // Arrange
        Calendar c = Calendar.getInstance();

        User user1 = new User("john.doe@gmail.com", "123-45-6789", "John", "Doe",
                    new Address(12345, "123 Main Street", "Apartment #3", "Anytown", "CA", 12345),
                    c.getTime(), "Single");
        User user2 = new User("jane.doe@gmail.com", "123-45-6789", "Jane", "Doe",
                    new Address(12345, "123 Main Street", "Apartment #4", "Anytown", "CA", 12345),
                    c.getTime(), "Married Filing Separately");
        List<User> users = Arrays.asList(user1, user2);

        // Mock the user service
        userService = mock(UserService.class);
        when(userService.findAllUsers()).thenReturn(users);

        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
