package com.skillstorm.group8.taxprep.test.forms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.skillstorm.group8.taxprep.forms.Form1099;

public class Form1099Test {
    
    @Test
    public void testCreate1099() {
        Form1099 form1099 = new Form1099();
        form1099.setPayerTIN("123456789");
        form1099.setAmountWithheld(100.50);
        form1099.setEmployerName("SkilStorm");

        assertNotNull(form1099);

        // Assert the attributes of the retrievedForm1099 using assertEquals
        assertEquals("123456789", form1099.getPayerTIN());
        assertEquals(100.50, form1099.getAmountWithheld(), 0.001); // Use delta for double values
        assertEquals("SkilStorm", form1099.getEmployerName());    
        
        System.out.println("testCreate1099 Passed!");
    }

}
