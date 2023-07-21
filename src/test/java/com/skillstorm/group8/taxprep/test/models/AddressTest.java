package com.skillstorm.group8.taxprep.test.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.skillstorm.group8.taxprep.models.Address;


public class AddressTest {
    
    @Test
    public void testCreateAddress() {
        Address address = new Address();

        address.setStreetPrimary("123 Street Street");
        address.setStreetSecondary("APT #4");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode(10001);

        assertNotNull(address);

        assertEquals("123 Street Street", address.getStreetPrimary());
        assertEquals("APT #4", address.getStreetSecondary());
        assertEquals("New York", address.getCity());
        assertEquals("NY", address.getState());
        assertEquals(10001, address.getZipCode());

        System.out.println("testCreateAddress Passed!");
    }
}
