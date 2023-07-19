package com.skillstorm.group8.taxprep.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMINS")
public class Admin {
    
    /* ATTRIBUTES */

    // Primary key
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Admin's first name
    @Column(name = "first_name")
    private String firstName;

    // Admin's last name
    @Column(name = "last_name")
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
