package com.skillstorm.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.skillstorm.group8.taxprep.models.FormW2;

public class FormW2Test {

    // The model unit tests essentially test creation of an instance and setting attributes of the model

    @Test
    public void testCreateFormW2() {
        // Create a new FormW2 object
        FormW2 formW2 = new FormW2("12345", "12-3456789", "john.doe@gmail.com", 100000, 2000, "Acme Corporation");

        // Assert that the FormW2 object was created successfully
        assertEquals("12-3456789", formW2.getEmployerEIN());
        assertEquals("john.doe@gmail.com", formW2.getEmail());
        assertEquals(100000, formW2.getAmountEarned());
        assertEquals(2000, formW2.getAmountWithheld());
        assertEquals("Acme Corporation", formW2.getEmployerName());
        assertNull(formW2.getAddress());
    }
    @Test
    public void testSetEmployerEIN() {
        // Create a new FormW2 object
        FormW2 formW2 = new FormW2();

        // Set the employer EIN of the FormW2 object
        formW2.setEmployerEIN("12-3456789");

        // Assert that the employer EIN was set correctly
        assertEquals("12-3456789", formW2.getEmployerEIN());
    }

    @Test
    public void testSetAmountWithheld() {
        // Create a new FormW2 object
        FormW2 formW2 = new FormW2();

        // Set the amount withheld of the FormW2 object
        formW2.setAmountWithheld(2000);

        // Assert that the amount withheld was set correctly
        assertEquals(2000, formW2.getAmountWithheld());
    }

    @Test
    public void testSetEmail() {
        // Create a new FormW2 object
        FormW2 formW2 = new FormW2();

        // Set the email of the FormW2 object
        formW2.setEmail("john.doe@gmail.com");

        // Assert that the email was set correctly
        assertEquals("john.doe@gmail.com", formW2.getEmail());
    }

    @Test
    public void testSetAmountEarned() {
        // Create a new FormW2 object
        FormW2 formW2 = new FormW2();

        // Set the amount earned of the FormW2 object
        formW2.setAmountEarned(100000);

        // Assert that the amount earned was set correctly
        assertEquals(100000, formW2.getAmountEarned());
    }

    @Test
    public void testSetEmployerName() {
        // Create a new FormW2 object
        FormW2 formW2 = new FormW2();

        // Set the employer name of the FormW2 object
        formW2.setEmployerName("Acme Corporation");

        // Assert that the employer name was set correctly
        assertEquals("Acme Corporation", formW2.getEmployerName());
    }
}