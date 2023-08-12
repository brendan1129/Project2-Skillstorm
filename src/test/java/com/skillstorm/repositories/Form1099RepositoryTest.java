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
import com.skillstorm.group8.taxprep.models.Form1099;
import com.skillstorm.group8.taxprep.repositories.Form1099Repository;

@SpringBootTest(classes=Form1099Repository.class)
@SpringJUnitConfig
public class Form1099RepositoryTest {

    @Mock
    private Form1099Repository form1099Repository;

    @Test
    public void testFindForm1099sByPayerTIN() throws Exception {
        // Arrange
        String payerTIN = "123456789";
        String email = "johndoe@example.com";
        double amountEarned = 10000;
        double amountWithheld = 2000;
        String businessName = "Acme Corporation";
        Address address = new Address(12345, "123 Main Street", "Anytown", "CA", 12345);
        Form1099 form1099 = new Form1099("12345", payerTIN, email, amountEarned, amountWithheld, businessName, address);
        form1099Repository.insert(form1099);
        Mockito.when(form1099Repository.findForm1099sByPayerTIN(payerTIN)).thenReturn(Optional.of(form1099));

        // Act
        Optional<Form1099> actualForm1099 = form1099Repository.findForm1099sByPayerTIN(payerTIN);

        // Assert
        assertTrue(actualForm1099.isPresent());
        assertEquals(form1099, actualForm1099.get());
        form1099Repository.delete(form1099);
    }

    @Test
    public void testFindForm1099sByEmail() throws Exception {
        // Arrange
        String payerTIN = "123456789";
        String email = "johndoe@example.com";
        double amountEarned = 10000;
        double amountWithheld = 2000;
        String businessName = "Acme Corporation";
        Address address = new Address(12345, "123 Main Street", "Anytown", "CA", 12345);
        Form1099 form1099 = new Form1099("12345", payerTIN, email, amountEarned, amountWithheld, businessName, address);
        form1099Repository.insert(form1099);
        List<Form1099> form1099s = Arrays.asList(form1099);
        Mockito.when(form1099Repository.findForm1099sByEmail(email)).thenReturn(Optional.of(form1099s));

        // Act
        Optional<List<Form1099>> actualForm1099s = form1099Repository.findForm1099sByEmail(email);

        // Assert
        assertTrue(actualForm1099s.isPresent());
        assertEquals(form1099s, actualForm1099s.get());
        form1099Repository.delete(form1099);
    }
}