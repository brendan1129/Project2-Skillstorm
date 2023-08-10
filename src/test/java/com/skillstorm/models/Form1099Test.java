package com.skillstorm.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.skillstorm.group8.taxprep.models.Form1099;

public class Form1099Test {
    
    // The model unit tests essentially test creation of an instance and setting attributes of the model

    @Test
    public void testCreateForm1099() {
        // Create a new Form1099 object
        Form1099 form1099 = new Form1099("1234567890", "12-3456789", "john.doe@gmail.com", 100000, 2000, "Acme Corporation");

        // Assert that the Form1099 object was created successfully
        assertEquals("12-3456789", form1099.getPayerTIN());
        assertEquals("john.doe@gmail.com", form1099.getEmail());
        assertEquals(100000, form1099.getAmountEarned());
        assertEquals(2000, form1099.getAmountWithheld());
        assertEquals("Acme Corporation", form1099.getBusinessName());
    }

    @Test
    public void testSetPayerTIN() {
        // Create a new Form1099 object
        Form1099 form1099 = new Form1099();

        // Set the payer TIN of the Form1099 object
        form1099.setPayerTIN("12-3456789");

        // Assert that the payer TIN was set correctly
        assertEquals("12-3456789", form1099.getPayerTIN());
    }

    @Test
    public void testSetAmountWithheld() {
        // Create a new Form1099 object
        Form1099 form1099 = new Form1099();

        // Set the amount withheld of the Form1099 object
        form1099.setAmountWithheld(2000);

        // Assert that the amount withheld was set correctly
        assertEquals(2000, form1099.getAmountWithheld());
    }

    @Test
    public void testSetPayerFirstName() {
        // Create a new Form1099 object
        Form1099 form1099 = new Form1099();

        // Set the payer first name of the Form1099 object
        form1099.setPayerFirstName("John");

        // Assert that the payer first name was set correctly
        assertEquals("John", form1099.getPayerFirstName());
    }

    @Test
    public void testSetPayerLastName() {
        // Create a new Form1099 object
        Form1099 form1099 = new Form1099();

        // Set the payer last name of the Form1099 object
        form1099.setPayerLastName("Doe");

        // Assert that the payer last name was set correctly
        assertEquals("Doe", form1099.getPayerLastName());
    }

    @Test
    public void testSetEmail() {
        // Create a new Form1099 object
        Form1099 form1099 = new Form1099();

        // Set the email of the Form1099 object
        form1099.setEmail("john.doe@gmail.com");

        // Assert that the email was set correctly
        assertEquals("john.doe@gmail.com", form1099.getEmail());
    }
    @Test
    public void testSetAmountEarned() {
        // Create a new Form1099 object
        Form1099 form1099 = new Form1099();

        // Set the amount earned of the Form1099 object
        form1099.setAmountEarned(10000);

        // Assert the amount earned was set correctly
        assertEquals(10000, form1099.getAmountEarned());
    }
}
