package com.skillstorm.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.skillstorm.group8.taxprep.models.Address;
import com.skillstorm.group8.taxprep.models.FormW2;
import com.skillstorm.group8.taxprep.repositories.FormW2Repository;

@SpringBootTest(classes=FormW2Repository.class)
@SpringJUnitConfig
public class FormW2RepositoryTest {
    
    @Mock
    private FormW2Repository formW2Repository;

    @Test
    public void testFindFormW2sByEmployerEIN() throws Exception {
        // Arrange
        String employerEIN = "123456789";
        String email = "johndoe@example.com";
        double amountEarned = 10000;
        double amountWithheld = 2000;
        String employerName = "Acme Corporation";
        Address address = new Address(12345, "123 Main Street", "Anytown", "CA", 12345);
        FormW2 w2 = new FormW2("12345", employerEIN, email, amountEarned, amountWithheld, employerName, address);
        formW2Repository.insert(w2);
        Mockito.when(formW2Repository.findFormW2sByEmployerEIN(employerEIN)).thenReturn(Optional.of(w2));

        // Act
        Optional<FormW2> actualW2 = formW2Repository.findFormW2sByEmployerEIN(employerEIN);

        // Assert
        assertTrue(actualW2.isPresent());
        assertEquals(w2, actualW2.get());
        formW2Repository.delete(w2);
    }

    @Test
    public void testFindFormW2sByEmail() throws Exception {
        // Arrange
        String employerEIN = "123456789";
        String email = "johndoe@example.com";
        double amountEarned = 10000;
        double amountWithheld = 2000;
        String employerName = "Acme Corporation";
        Address address = new Address(12345, "123 Main Street", "Anytown", "CA", 12345);
        FormW2 w2 = new FormW2("12345", employerEIN, email, amountEarned, amountWithheld, employerName, address);
        formW2Repository.insert(w2);
        List<FormW2> w2s = Arrays.asList(w2);
        Mockito.when(formW2Repository.findFormW2sByEmail(email)).thenReturn(Optional.of(w2s));

        // Act
        Optional<List<FormW2>> actualW2s = formW2Repository.findFormW2sByEmail(email);

        // Assert
        assertTrue(actualW2s.isPresent());
        assertEquals(w2s, actualW2s.get());
        formW2Repository.delete(w2);
    }
}
