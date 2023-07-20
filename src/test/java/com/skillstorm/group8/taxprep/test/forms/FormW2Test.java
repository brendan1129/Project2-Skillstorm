package com.skillstorm.group8.taxprep.test.forms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.skillstorm.group8.taxprep.forms.FormW2;

public class FormW2Test {
    @Test
    public void testCreateW2() {
        FormW2 formw2 = new FormW2();
        formw2.setEmployerEIN("0123456789");
        formw2.setAmountWithheld(100.50);
        formw2.setPayerFirstName("John");
        formw2.setPayerLastName("Doe");


        assertNotNull(formw2);

        // Assert the attributes of the retrievedformw2 using assertEquals
        assertEquals("0123456789", formw2.getEmployerEIN());
        assertEquals(100.50, formw2.getAmountWithheld(), 0.001); // Use delta for double values
        assertEquals("John", formw2.getPayerFirstName());  
        assertEquals("Doe", formw2.getPayerLastName());  
        

        System.out.println("testCreateW2 Passed!");
    }
}