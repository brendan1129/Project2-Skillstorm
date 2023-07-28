package com.skillstorm.group8.taxprep.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    /* ATTRIBUTES */

    // Primary key
    @Id
    @Column(name = "email", length = 50, unique = true)
    private String email;

    // Social Security Number
    @Column(name = "ssn", length = 11, unique = true)
    private String ssn;

    // User's first name
    @Column(name = "first_name")
    private String firstName;

    // User's last name
    @Column(name = "last_name")
    private String lastName;

    // User's password
    @Column(name = "password")
    private String password;

    // Many users can be associated with one address
    @ManyToOne
    // @JsonBackReference
    @JoinColumn(name = "address") // Foreign key column in the USERS table
    private Address address;

    @Column(name = "dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    // User's marital status
    @Column(name = "marital_status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    /* CONSTRUCTORS */

    public User() {
        // Default constructor
    }

    /* GETTERS AND SETTERS */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
