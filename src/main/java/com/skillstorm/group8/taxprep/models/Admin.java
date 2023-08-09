package com.skillstorm.group8.taxprep.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin {
    
    /* ATTRIBUTES */

    // Primary key
    @Id
    private int id;

    // Admin's first name
    private String firstName;

    // Admin's last name
    private String lastName;

    /* CONSTRUCTORS */

    public Admin() {
        // Default constructor
    }

    /* GETTERS AND SETTERS */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
